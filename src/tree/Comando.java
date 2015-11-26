package tree;
public class Comando extends Node {
	
	public Comando(String id, Exp exp) {
		this.left = new Assign(id, exp);
		this.right = null;
	}
	
	//while
	public Comando(Exp e, Bloco b) {
		this.left = new While(e, b);
		this.right = null;
	}

	public void cgen() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print("(COMANDO ");
		if(left!=null)
			left.print();
        System.out.print(", ");
        if(right!=null)
        	right.print();
        System.out.print(")");
		
	}
	
	
}