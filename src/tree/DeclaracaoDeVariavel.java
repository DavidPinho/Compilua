package tree;

public class DeclaracaoDeVariavel extends Node{

	
	public DeclaracaoDeVariavel(String identifier) {
		this.left = new Identifier(identifier);
		this.right = null;
	}
	
	public DeclaracaoDeVariavel(String identifier, Exp exp) {
		this.left = new Identifier(identifier);
		this.right = exp;
	}
	
	
	@Override
	public void cgen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print() {
		System.out.print("(DECLARA_VAR");
		left.print();        
        System.out.print(", ");
        right.print();     	
        System.out.print(")");
		
	}

}
