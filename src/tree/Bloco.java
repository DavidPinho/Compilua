package tree;
public class Bloco extends Node {
	
	public Bloco(Bloco b, Comando c) {
		this.left = b;
		this.right = c;
		if(Node.root == null) {
			Node.root = this;
		}
	}

	@Override
	public void cgen() {
		// TODO Auto-generated method stub
		
	}

	
}