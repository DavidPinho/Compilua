package tree;

public class While extends Comando {
	
	public While(Exp e, Bloco b) {
		this.left = e;
		this.right = b;
	}
	@Override
	public void cgen() {
		// TODO Auto-generated method stub

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
