package tree;

public class Token {
	
	//Um token possui um tipo e um valor
	private TokenType type;
	private String value;
	private int line;
	
	
	public Token(TokenType type, String value){
		this.type = type;
		this.value = value;
		//this.line = line;
	}


	public TokenType getType() {
		return type;
	}


	public void setType(TokenType type) {
		this.type = type;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public int getLine() {
		return line;
	}


	public void setLine(int line) {
		this.line = line;
	}
	
	
	

}
