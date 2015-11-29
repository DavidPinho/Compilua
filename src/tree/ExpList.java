package tree;

import parser.CompilerException;
import main.MIPSPrinter;

public class ExpList extends Node {
	
	public ExpList(Exp e1, ExpList e2) {
		this.left=e1;
		this.right=e2;
	}

	@Override
	public void cgen() {
		if(this.left != null) {
			this.left.cgen();
			//if (MIPSPrinter.isVarOnDataSegment(left.getValue())) {
				//MIPSPrinter.print("lw $a0, " + left.getValue(), 't');
				MIPSPrinter.print("li $v0, 1", 't');
				MIPSPrinter.print("syscall", 't');
			//} else {
				//throw new CompilerException("linha"); //TODO: implementar linhas
			//}
		}
		if(this.right != null) {
			this.right.cgen();
		}
	}

	@Override
	public void print() {
		System.out.print("(EXPLIST ");
        left.print();
        if(this.right!=null){
	        System.out.print(", ");
	        right.print();
        }
        System.out.print(")");
		
	}

}
