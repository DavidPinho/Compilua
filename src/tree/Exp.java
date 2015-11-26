package tree;
public class Exp extends Node {
	
	
	public Exp(java.lang.Number num) {
		this.left = new Number(num);
		this.right = null;
	}
	
	public Exp(String id) {
		this.left = new Identifier(id);
		this.right = null;
	}
	
	
	public Exp(Exp exp) {
		this.left = exp;
		this.right = null;
	}
	
	
	public void cgen() {
		if(this.left != null) {
			this.left.cgen();
		}
		if(this.right != null) {
			this.right.cgen();
		}
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print("(EXP ");
        left.print();
        System.out.print(", ");
        right.print();
        System.out.print(")");
		
	}
	
}