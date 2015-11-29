package tree;

import main.MIPSPrinter;

public class OpUnaria extends Node {
	private int opUnaria = -1;
	public OpUnaria(int opunaria, Exp exp) {
		this.left = exp;
		this.right = null;
		this.opUnaria =opunaria;
	}

	@Override
	public void cgen() {
		switch (opUnaria) {
		case 33:
			//NOT_KWORD
			
			if(this.left.left instanceof Opbin){
				
				switch (((Opbin)this.left.left).getOpBin()) {
				case 27:
					//LESS_OP
					printComparison("bge");
					break;
				case 25:
					//LESSEQUALS_OP
					printComparison("bgt");
					break;
				case 28:
					//MORE_OP
					printComparison("ble");
					break;
				case 26:
					//MOREEQUALS_OP
					printComparison("blt");
					break;
				case 29:
					//EQUALS_OP
					printComparison("bne");
					break;
				case 30:
					//DIFFERENT_OP
					printComparison("beq");
					break;

				default:
					break;
				}
					
				
			}
			break;
		case 20:
			//UNOP MINUS
			if(this.left instanceof Number){
				int value = Math.round(Float.valueOf(this.left.value))*-1;
				MIPSPrinter.print("li $a0, "+Integer.toString(value), 't');
			}
			break;

		default:
			break;
		}		
	}

	@Override
	public void print() {
		switch (opUnaria) {
		case 20:
			//UNOP
			System.out.print("(MINUS_UNOP ");
			break;
		case 33:
			//NOT_KWORD
			System.out.print("(NOT_UN");
			break;

		default:
			break;
		}
		left.print();        
        System.out.print(")");		
	}
	
	private void printComparison(String op){
		this.left.left.left.cgen();
		MIPSPrinter.print("sw $a0, 0($sp)", 't');
		MIPSPrinter.print("addiu $sp, $sp, -4", 't');
		this.left.left.right.cgen();
		MIPSPrinter.print("lw $t1, 4($sp)", 't');
		MIPSPrinter.print("addiu $sp, $sp, 4", 't');
		int blocoNumber=0;
		if(MIPSPrinter.labelJump.equals("TRUE"))
			blocoNumber= MIPSPrinter.ifCount;
		else if (MIPSPrinter.labelJump.equals("WHILE")) {
			blocoNumber= MIPSPrinter.whileCount;
		}
			
		MIPSPrinter.print(op+" $t1, $a0, "+MIPSPrinter.labelJump+Integer.toString(blocoNumber), 't');
	}
	
	

}
