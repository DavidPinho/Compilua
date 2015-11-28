package tree;

import main.MIPSPrinter;

public class IfComando extends Comando{
	
	
	public IfComando(Exp e, Bloco b) {
		this.left = e;
		this.right = b;
	}
	
	@Override
	public void cgen() {	
		String id = MIPSPrinter.ifCount.remove(MIPSPrinter.ifCount.size()-1);
		MIPSPrinter.print("", 't');
		MIPSPrinter.print(MIPSPrinter.labelJump+id+":", 't');
		MIPSPrinter.print("", 't');
		this.right.cgen();
		MIPSPrinter.print("", 't');
		MIPSPrinter.print("ENDIF"+id+":", 't');
		MIPSPrinter.print("", 't');
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
