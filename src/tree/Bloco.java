package tree;
public class Bloco extends Node {
	
	public Bloco(Bloco b, Comando c) {
		this.left = b;
		this.right = c;
	}

	@Override
	public void cgen() {
		// TODO Auto-generated method stub
		
	}

	
}