package tree;

public class IfComando extends Comando{
	
	public IfComando(Exp e, Bloco b) {
		this.left = e;
		this.right = b;
	}
	
	@Override
	public void cgen() {
		// TODO Auto-generated method stub

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
