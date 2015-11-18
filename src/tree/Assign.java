package tree;

import main.MIPSPrinter;

public class Assign extends Node {


	public Assign(Identifier id, Exp exp) {
		this.left = id;
		this.right = exp;
	}
	
	public void cgen() {
		this.left.cgen();//declaracao da variavel
		this.right.cgen();//exp
		//atribuicao do valor da exp na variavel
		MIPSPrinter.print("sw $a0, "+
		((Identifier)this.left).getValue(), 't');
	}
}