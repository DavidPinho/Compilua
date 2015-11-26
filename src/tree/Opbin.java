package tree;

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
}
