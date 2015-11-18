package tree;

public class Opbin extends Node {
	public Opbin(Exp e1, Exp e2) {
		this.left = e1;
		this.right = e2;
	}
}
