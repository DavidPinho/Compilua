package tree;

import main.MIPSPrinter;

public class ElseBloco extends Bloco {
	
	public ElseBloco(Bloco b) {
		this.left = b;
		this.right = null;
	}

	@Override
	public void cgen(){
		MIPSPrinter.prevIfCount = MIPSPrinter.ifCount;
		MIPSPrinter.print("", 't');
		MIPSPrinter.print("FALSE"+Integer.toString(MIPSPrinter.elseCount)+":", 't');
		MIPSPrinter.print("", 't');
		MIPSPrinter.elseCount++;
		MIPSPrinter.ifCount++;
		this.left.cgen();
		MIPSPrinter.ifCount = MIPSPrinter.prevIfCount;
	}
	
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print("(ELSE ");
		if(left!=null){
			left.print();
		    
		} 
	}

}
