package tree;

import main.MIPSPrinter;

public class While extends Comando {
	
	public While(Exp e, Bloco b) {
		this.left = e;
		this.right = b;
	}
	@Override
	public void cgen() {
		MIPSPrinter.labelJump = "WHILE";
		int count = MIPSPrinter.whileCount;
		MIPSPrinter.print("WHILE_CONDITION"+Integer.toString(count)+":", 't');
		this.left.cgen();	
		MIPSPrinter.print("b ENDWHILE"+count, 't');
		MIPSPrinter.print("", 't');
		
		
		MIPSPrinter.print(MIPSPrinter.labelJump+Integer.toString(count)+":", 't');
		MIPSPrinter.print("", 't');
		MIPSPrinter.whileCount++;
		this.right.cgen();//gera o bloco
		MIPSPrinter.print("b WHILE_CONDITION"+count, 't');
		MIPSPrinter.print("", 't');
		MIPSPrinter.print("ENDWHILE"+count+":", 't');
		MIPSPrinter.print("", 't');
		
		
		
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
