package tree;

import main.MIPSPrinter;

public class Number extends Node {
	public Number(java.lang.Number n1) {
		this.value = ""+ n1;
	}
	
	public void cgen() {
		MIPSPrinter.print("li $a0, "+Integer.getInteger(this.value), 't');
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print("(NUMBER "+this.value+")");
        left.print();
        System.out.print(", ");
        right.print();
        System.out.print(")");
		
	}
}