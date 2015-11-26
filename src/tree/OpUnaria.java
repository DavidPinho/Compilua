package tree;

public class OpUnaria extends Node {
	private int opUnaria = -1;
	public OpUnaria(int opunaria, Exp exp) {
		this.left = exp;
		this.right = null;
		this.opUnaria =opunaria;
	}

	@Override
	public void cgen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print() {
		switch (opUnaria) {
		case 35:
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

}
