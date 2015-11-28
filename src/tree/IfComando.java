package tree;

import main.MIPSPrinter;

public class IfComando extends Comando{
	
	
	public IfComando(Exp e, Bloco b) {
		this.left = e;
		this.right = b;
	}
	
	@Override
	public void cgen() {
		MIPSPrinter.labelJump = "true";
		this.left.cgen(); 
		MIPSPrinter.print("", 't');
		MIPSPrinter.print(MIPSPrinter.labelJump+Integer.toString(MIPSPrinter.ifCount)+":", 't');
		MIPSPrinter.ifCount++;
		this.right.cgen();
		

	}
	@Override
	public void print() {
		System.out.print("(IF ");
		left.print();        
        System.out.print(", ");
        right.print();         
        System.out.print(")");       
	}

}
