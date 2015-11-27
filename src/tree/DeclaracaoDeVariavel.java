package tree;

import main.MIPSPrinter;

public class DeclaracaoDeVariavel extends Comando{

	
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
		MIPSPrinter.print(""+this.left.value+": .word 0", 'd');
		
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
