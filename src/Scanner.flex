/**
*   JFlex Scanner
*/

import java_cup.runtime.Symbol;
import java_cup.runtime.*;





%%

%public
%class Lexer
%cup
%implements sym
%line
%column

%{
  SymbolFactory symbolFactory = new DefaultSymbolFactory();
  
  public SymbolFactory getSymbolFactory() {
  	return symbolFactory;
  }

  StringBuffer string = new StringBuffer();

  private Symbol symbol(int sym) {
    Symbol symb = new Symbol(sym, yyline+1, yycolumn+1);
    return symb;
  }
  
  private Symbol symbol(int sym, Object val) {
    Symbol symb = new Symbol(sym, yyline+1, yycolumn+1, val);
    return symb;
  }
  
  private void error(String message) {
    System.out.println("Error at line "+(yyline+1)+", column "+(yycolumn+1)+" : "+message);
  }
%} 

white_space = [ \r\n\t\f]+
	
Identifier = [_a-zA-Z]+[_0-9a-zA-Z]*

line_terminator = \r|\n|\r\n

Number = (0 | [1-9][0-9]*) ("."[0-9]+)?

input_character = [^\r\n]



//Comentarios 

Comment = {EndOfLineComment} | {MultipleLineComment}
EndOfLineComment = "--" {input_character}* {line_terminator}
MultipleLineComment = "--[""="*"[" {CommentContent} "]""="*"]"
CommentContent = (!("]""="*"]"))*

%state STRINGDOUBLE
%state STRINGSINGLE
%state STRINGBRACKET
%state MULTILINE

%%

<YYINITIAL> {

\" { string.setLength(0); yybegin(STRINGDOUBLE); }
\' { string.setLength(0); yybegin(STRINGSINGLE); }
\[\[ { string.setLength(0); yybegin(STRINGBRACKET); }

/* keywords */
"local"         {return symbol(sym.LOCAL_KWORD); }
"function"      { return symbol(sym.FUNCTION_KWORD); }
"end"			{ return symbol(sym.END_KWORD); }
"do"			{ return symbol(sym.DO_KWORD); }
"while"			{ return symbol(sym.WHILE); }
"for"			{ return symbol(sym.FOR_KWORD); }
"in"			{ return symbol(sym.IN_KWORD); }
"repeat"		{ return symbol(sym.REPEAT_KWORD); }
"until"			{ return symbol(sym.UNTIL_KWORD); }
"if"			{ return symbol(sym.IF_KWORD); }
"then"			{ return symbol(sym.THEN_KWORD); }
"else"			{ return symbol(sym.ELSE_KWORD); }
"elseif"			{ return symbol(sym.ELSEIF_KWORD); }
"return"		{ return symbol(sym.RETURN_KWORD); }
"break"			{ return symbol(sym.BREAK_KWORD); }
"nil"			{ return symbol(sym.NIL_KWORD); }
"false"			{ return symbol(sym.FALSE_KWORD); }
"true"			{ return symbol(sym.TRUE_KWORD); }
"..."			{ return symbol(sym.THREEDOTS); }

";"               { return symbol(sym.SEMICOLON); }
","		{ return symbol(sym.COMA); }

"=="             { return symbol(sym.EQUALS_OP); }
"~="             { return symbol(sym.DIFFERENT_OP); }
"<="             { return symbol(sym.LESSEQUALS_OP); }
"<"              { return symbol(sym.LESS_OP); }
">"              { return symbol(sym.MORE_OP); }
">="             { return symbol(sym.MOREEQUALS_OP); }
"+"              { return symbol(sym.PLUS_OP); }
"-"              { return symbol(sym.MINUS_OP); }
"*"              { return symbol(sym.TIMES_OP); }
"/"              { return symbol(sym.SLASH_OP); }
"^"              { return symbol(sym.POT_OP); }
"%"              { return symbol(sym.PERCENT_OP); }
".."			 { return symbol(sym.TWODOTS); }
"and"            { return symbol(sym.AND_KWORD); }
"or"             { return symbol(sym.OR_KWORD); }
"."				 { return symbol(sym.DOT); }
":"				 { return symbol(sym.COLON); }

/* unary operators */

"not"			{ return symbol(sym.NOT_KWORD); }
"#"				{ return symbol(sym.HASH_OP); }


"(" 			{ return symbol(sym.LPAREN); }
")" 			{ return symbol(sym.RPAREN); }
"["				{ return symbol(sym.LBRACKET); }
"]"				{ return symbol(sym.RBRACKET); }
"{"				{ return symbol(sym.LBRACE); }
"}"				{ return symbol(sym.RBRACE); }

/* identifiers */
{Identifier}           { return symbol(sym.IDENTIFIER, yytext()); }
  
/* numbers */
{Number} { return symbol(sym.NUMBER, new Double(Double.parseDouble(yytext()))); }

/* assignment */
"="				{ return symbol(sym.ASSIGN_OP); }

/* white space */
{white_space}    {  }

/* comments */
{Comment} { /* ignore */ }

}

<STRINGDOUBLE> {
	"\"" 				{ yybegin(YYINITIAL);
					  return symbol(sym.STRING,
					  string.toString()); }
	[^\n\r\"\\]+ 	{ string.append( yytext() ); }
	
	"\\t" 			{ string.append("\t"); }
	"\\n" 			{ string.append("\n"); }
	"\\r" 			{ string.append("\r"); }
	/* Every other escape sequence is not valid */
	/*"\\." 			{ string.append(yytext()); }*/
	\\\"			{ string.append("\""); }
	"\n"			{ string.append("\n"); } // Multiline Strings
	\\\\            { string.append("\\"); }
	"\\"			{ string.append("");   }
	
}

<STRINGBRACKET> {
	\]\] 				{ yybegin(YYINITIAL);
					  return symbol(sym.STRING,
					  string.toString()); }
	[^\]]+ 	{ string.append( yytext() ); }
	"\\t" 			{ string.append("\t"); }
	"\\n" 			{ string.append("\n"); }
	"\\r" 			{ string.append("\r"); }
	\\\"			{ string.append("\""); }
	"\n"			{ string.append("\n"); } // Multiline Strings
	\\\\            { string.append("\\"); }
	"\\"			{ string.append("");   }
	
}


<STRINGSINGLE> {
	"'" 			{ yybegin(YYINITIAL);
					  return symbol(sym.STRING,
					  string.toString()); }
	[^\n\r"'"\\]+ 	{ string.append( yytext() ); }
	\\t 			{ string.append("\t"); }
	\\n 			{ string.append("\n"); }
	\\r 			{ string.append("\r"); }
	/*"\\."			{ string.append(yytext()); }*/
	\\\\            { string.append("\\"); }
	"\\\n"			{ string.append("\n"); } // Multiline Strings
	\\\'			{ string.append("\'"); }

}