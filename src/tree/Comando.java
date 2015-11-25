package tree;
public class Comando extends Node {
	
	public Comando(String id, Exp exp) {
		this.left = new Assign(id, exp);
		this.right = null;
	}

	public void cgen() {
		// TODO Auto-generated method stub
		
	}
	
	
}