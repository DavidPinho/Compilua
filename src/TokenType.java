
public enum TokenType {
	NEWLINE,// \n
	EOF,
	IDENTIFIER,
	NUMBER,
	BOOLEAN,
	STRING,
	USERDATA,
	THREAD,
	TABLE,
	LPAREN,
	RPAREN,
	LBRACE,//{
	RBRACE,
	LBRACKET,//[
	RBRACKET,
	SEMICOLON,
	COLON,
	COMA,
	DOT,
	TWODOTS,
	THREEDOTS,
	PLUS_OP,
	MINUS_OP,
	EQUALS_OP,
	DIFFERENT_OP,
	TIMES_OP,
	SLASH_OP,
	PERCENT_OP,
	POT_OP,//^
	HASH_OP,//#
	LESSEQUALS_OP,
	MOREEQUALS_OP,
	LESS_OP,
	MORE_OP,
	ASSIGN_OP,// =
	AND_KWORD,
	END_KWORD,
	IN_KWORD,
	REPEAT_KWORD,
	BREAK_KWORD,
	FALSE_KWORD,
	LOCAL_KWORD,
	RETURN_KWORD,
	DO_KWORD,
	FOR_KWORD,
	NIL_KWORD,
	THEN_KWORD,
	ELSE_KWORD,
	FUNCTION_KWORD,
	NOT_KWORD,
	TRUE_KWORD,
	ELSEIF_KWORD,
	IF_KWORD,
	OR_KWORD,
	UNTIL_KWORD,
	WHILE;   //Precisamos identificar os tipos de token aqui

}
