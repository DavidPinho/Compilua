package tree;

import main.MIPSPrinter;

public class Opbin extends Node {
	private int opBin = -1;
	public Opbin(Exp e1, int op, Exp e2) {
		this.left = e1;
		this.right = e2;
		opBin = op;
	}
	
	
	
	@Override
	public void cgen() {
		switch (opBin) {
		case 19:
			//PLUS_OP
			this.left.cgen();
			MIPSPrinter.print("sw $a0, 0($sp)", 't');
			MIPSPrinter.print("addiu $sp, $sp, -4", 't');
			this.left.cgen();
			MIPSPrinter.print("lw $t1, 4($sp)", 't');
			MIPSPrinter.print("add $a0, $a0, $t1", 't');
			MIPSPrinter.print("addiu $sp, $sp, 4", 't');
			
			break;
		case 20:
			//MINUS_OP
			break;
		case 21:
			//TIMES_OP
			break;
		case 22: 
			//SLASH_OP
			break;
		case 27:
			//LESS_OP
			break;
		case 25:
			//LESSEQUALS_OP
			break;
		case 28:
			//MORE_OP
			break;
		case 26:
			//MOREEQUALS_OP
			break;
		case 29:
			//EQUALS_OP
			break;
		case 30:
			//DIFFERENT_OP
			break;
		case 31:
			//AND_KWORD
			break;
		case 32:
			//OR_KWORD
			break;

		default:
			break;
		}
		
	}
	
	@Override
	public void print() {
		switch (opBin) {
		case 19:
			//PLUS_OP
			System.out.print("(PLUS ");	        
			break;
		case 20:
			//MINUS_OP
			System.out.print("(MINUS ");	
			break;
		case 21:
			//TIMES_OP
			System.out.print("(TIMES ");	
			break;
		case 22: 
			//SLASH_OP
			System.out.print("(SLASH ");	
			break;
		case 27:
			//LESS_OP
			System.out.print("(LESS_OP ");	
			break;
		case 25:
			//LESSEQUALS_OP
			System.out.print("(LESSEQUALS_OP ");	
			break;
		case 28:
			//MORE_OP
			System.out.print("(MORE_OP ");
			break;
		case 26:
			//MOREEQUALS_OP
			System.out.print("(MOREEQUALS_OP ");
			break;
		case 29:
			//EQUALS_OP
			System.out.print("(EQUALS_OP ");
			break;
		case 30:
			//DIFFERENT_OP
			System.out.print("(DIFFERENT_OP ");
			break;
		case 31:
			//AND_KWORD
			System.out.print("(AND_KWORD ");
			break;
		case 32:
			//OR_KWORD
			System.out.print("(OR_KWORD ");
			break;

		default:
			break;
		}
		left.print();
        System.out.print(", ");
        right.print();
        System.out.print(")");
		
	}
	
	
}
