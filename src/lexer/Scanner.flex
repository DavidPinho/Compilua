// JFlex scanner: Lua language lexer specification

import java_cup.runtime.*;

%%

//options and declarations

%class Lexer
%unicode
%cup
%cupdebug
%implements sym
%line
%column

%{
  StringBuffer string = new StringBuffer();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }
  
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }
  
  private void error(String message) {
    System.out.println("Error at line "+(yyline+1)+", column "+(yycolumn+1)+" : "+message);
  }
%} 

WhiteSpace = [ \r\n\t\f]+
	
Identifier = [_a-zA-Z]+[_0-9a-zA-Z]*

LineTerminator = \r|\n|\r\n

Number = (0 | [1-9][0-9]*) ("."[0-9]+)?

InputCharacter = [^\r\n]


//Comments

Comment = {EndOfLineComment} | {MultipleLineComment}
EndOfLineComment = "--" {InputCharacter}* {LineTerminator}
MultipleLineComment = "--[""="*"[" {CommentContent} "]""="*"]"
CommentContent = (!("]""="*"]"))*


//start conditions

%state STRINGDOUBLE
%state STRINGSINGLE
%state STRINGBRACKET

%%

<YYINITIAL> {

/**If the scanner matches a double quote, a single quote or a double bracket in state YYINITIAL 
*  we have recognised the start of a string literal. Therefore we clear our StringBuffer that will hold the content of this string literal 
*  and tell the scanner with yybegin(STRINGSOMETHING) to switch into the lexical state STRINGDOUBLE, STRINGSINGLE or STRINGBRACKET.
*/

\" { string.setLength(0); yybegin(STRINGDOUBLE); }
\' { string.setLength(0); yybegin(STRINGSINGLE); }
\[\[ { string.setLength(0); yybegin(STRINGBRACKET); }

/* keywords */

"do"			{ return symbol(sym.DO_KWORD); }
"else"			{ return symbol(sym.ELSE_KWORD); }
"end"			{ return symbol(sym.END_KWORD); }
"for"			{ return symbol(sym.FOR_KWORD); }
"if"			{ return symbol(sym.IF_KWORD); }
"then"			{ return symbol(sym.THEN_KWORD); }
"var"			{ return symbol(sym.VAR_KWORD); }
"while"			{ return symbol(sym.WHILE); }


/* arithmetic operators */

"+"              { return symbol(sym.PLUS_OP); }
"-"              { return symbol(sym.MINUS_OP); }
"*"              { return symbol(sym.TIMES_OP); }
"/"              { return symbol(sym.SLASH_OP); }


/* relational operators */

"=="             { return symbol(sym.EQUALS_OP); }
"~="             { return symbol(sym.DIFFERENT_OP); }
"<="             { return symbol(sym.LESSEQUALS_OP); }
"<"              { return symbol(sym.LESS_OP); }
">"              { return symbol(sym.MORE_OP); }
">="             { return symbol(sym.MOREEQUALS_OP); }

/* logic operators */

"and"            { return symbol(sym.AND_KWORD); }
"or"             { return symbol(sym.OR_KWORD); }
"not"			{ return symbol(sym.NOT_KWORD); }


/* other symbols */


"="				{ return symbol(sym.ASSIGN_OP); }
";"             { return symbol(sym.SEMICOLON); }
","				{ return symbol(sym.COMA); }
"(" 			{ return symbol(sym.LPAREN); }
")" 			{ return symbol(sym.RPAREN); }



/* identifiers */
{Identifier}           { return symbol(sym.IDENTIFIER, yytext()); }
  
/* numbers */
{Number} { return symbol(sym.NUMBER, new Double(Double.parseDouble(yytext()))); }

/* white space */
{WhiteSpace}    {  }

/* comments */
{Comment} { /* ignore */ }

}

<STRINGDOUBLE> {
	"\"" 			{ yybegin(YYINITIAL);
					  return symbol(sym.STRING,
					  string.toString()); }
	[^\n\r\"\\]+ 	{ string.append( yytext() ); }
	
	"\\t" 			{ string.append("\t"); }
	"\\n" 			{ string.append("\n"); }
	"\\r" 			{ string.append("\r"); }
	\\\"			{ string.append("\""); }
	"\n"			{ string.append("\n"); } 
	\\\\            { string.append("\\"); }
	"\\"			{ string.append("");   }
	
}

<STRINGBRACKET> {
	\]\] 			{ yybegin(YYINITIAL);
					  return symbol(sym.STRING,
					  string.toString()); }
	[^\]]+ 			{ string.append( yytext() ); }
	"\\t" 			{ string.append("\t"); }
	"\\n" 			{ string.append("\n"); }
	"\\r" 			{ string.append("\r"); }
	\\\"			{ string.append("\""); }
	"\n"			{ string.append("\n"); } 
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
	\\\\            { string.append("\\"); }
	"\\\n"			{ string.append("\n"); } 
	\\\'			{ string.append("\'"); }

}

 /* error fallback */
    [^]                              { throw new Error("Illegal character <"+
                                                        yytext()+"> at line:"+yyline+1); }