package tree;
public class Assign extends Node {


	public Assign(Identifier id, Exp exp) {
		this.left = id;
		this.right = exp;
	}
	
	public void cgen() {
		this.left.cgen();
		//TODO: fazer o codigo do MIPS32 pra stack machine
		this.right.cgen();
		//TODO: fazer o codigo MIPS32 para desalocar da pilha
	}
}