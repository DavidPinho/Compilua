
public class Token {
	
	//Um token possui um tipo e um valor
	private int type;
	private String value;
	
	
	public Token(int type, String value){
		this.type = type;
		this.value =value;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}
	
	
	

}
