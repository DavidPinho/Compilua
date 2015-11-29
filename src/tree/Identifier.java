package tree;

import main.MIPSPrinter;


public class Identifier extends Exp {
	public Identifier(String id) {
		this.value = id;
	}
	
	public void cgen() {
		MIPSPrinter.print("lw $a0, "+ value, 't');
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