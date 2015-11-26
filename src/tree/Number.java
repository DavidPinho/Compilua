package tree;

import main.MIPSPrinter;

public class Number extends Exp {
	public Number(java.lang.Number n1) {
		this.value = ""+ n1;
	}
	
	public void cgen() {
		MIPSPrinter.print("li $a0, "+Integer.getInteger(this.value), 't');
	}
	
	@Override
	public void print() {
		System.out.print("(NUMBER "+this.value+")");   
	}
}