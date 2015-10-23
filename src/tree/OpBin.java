package tree;
public class OpBin extends Node {
	public Exp leftexp;
	public int op;
	public Exp rightexp;

	public OpBin(Exp leftexp, int op, Exp rightexp) {
		this.leftexp = leftexp;
		if (leftexp != null) leftexp.setParent(this);
		this.op = op;
		this.rightexp = rightexp;
		if (rightexp != null) rightexp.setParent(this);
	}
}