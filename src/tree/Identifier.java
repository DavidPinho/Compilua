package tree;


public class Identifier extends Exp {
	public Identifier(String id) {
		this.value = id;
	}
	
	public void cgen() {
		
	}
	
	public String getValue() {
		return this.value;
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print("(IDENTIFIER "+this.value+")");        
		
	}
	
}