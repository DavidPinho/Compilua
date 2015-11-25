package tree;

import main.MIPSPrinter;

public class Identifier extends Node {
	public Identifier(String id) {
		this.value = id;
	}
	
	public void cgen() {
		MIPSPrinter.print(""+this.value+": .word 0", 'd');
	}
	
	public String getValue() {
		return this.value;
	}
}