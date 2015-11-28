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
		//declaracao da variavel
		MIPSPrinter.print(""+this.left.value+": .word 0", 'd');
		if(right != null) {
			right.cgen();
			MIPSPrinter.print("sw $a0, "+
					((Identifier)this.left).getValue(), 't');
		}
	}

	@Override
	public void print() {
		System.out.print("(DECLARA_VAR");
		left.print();        
        System.out.print(", ");
        if(right != null) {
        	System.out.print("(ASSIGNMENT ");
        	right.print();   
        	System.out.print(")");
        }
        System.out.print(")");
		
	}

}
