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
		case 16:
			//PLUS_OP
			break;
		case 17:
			//MINUS_OP
			break;
		case 18:
			//TIMES_OP
			break;
		case 19: 
			//SLASH_OP
			break;
		case 22:
			//LESS_OP
			break;
		case 20:
			//LESSEQUALS_OP
			break;
		case 23:
			//MORE_OP
			break;
		case 21:
			//MOREEQUALS_OP
			break;
		case 24:
			//EQUALS_OP
			break;
		case 25:
			//DIFFERENT_OP
			break;
		case 26:
			//AND_KWORD
			break;
		case 27:
			//OR_KWORD
			break;

		default:
			break;
		}
		
	}
}
