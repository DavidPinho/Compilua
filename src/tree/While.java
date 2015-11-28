package tree;

import main.MIPSPrinter;

public class While extends Comando {
	
	public While(Exp e, Bloco b) {
		this.left = e;
		this.right = b;
	}
	@Override
	public void cgen() {
		int count = MIPSPrinter.whileCount;
		MIPSPrinter.labelJump = "WHILE";
		MIPSPrinter.print(MIPSPrinter.labelJump+Integer.toString(count)+":", 't');
		MIPSPrinter.whileCount++;
		this.right.cgen();//gera o bloco
		MIPSPrinter.print("WHILE_CONDITION"+Integer.toString(count)+":", 't');
		MIPSPrinter.whileCount--;
		this.left.cgen();
		MIPSPrinter.whileCount++;
		
	}
	@Override
	public void print() {
		System.out.print("(WHILE ");
		left.print();        
        System.out.print(", ");
        right.print();     	
        System.out.print(")");		
	}

}
