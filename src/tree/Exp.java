package tree;
public class Exp extends Node {
	
	
	public Exp(Number num) {
		this.left = num;
		this.right = null;
	}
	
	public Exp(Identifier id) {
		this.left = id;
		this.right = null;
	}
	
	public Exp(ChamadaDeFuncao c) {
		this.left = c;
		this.right = null;
	}
	
	public Exp(Exp exp) {
		this.left = exp;
		this.right = null;
	}
	
	public Exp(OpUnaria op, Exp e) {
		this.left = op;
		this.right = e;
	}
	
	public void cgen() {
		if(this.left != null) {
			this.left.cgen();
		}
		if(this.right != null) {
			this.right.cgen();
		}
	}
	
}