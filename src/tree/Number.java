package tree;

import main.MIPSPrinter;

public class Number extends Node {
	public Number(Integer num) {
		this.value = ""+ num;
	}
	
	public void cgen() {
		MIPSPrinter.print("li $a0, "+Integer.getInteger(this.value), 't');
	}
}