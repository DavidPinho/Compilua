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
	
	
}