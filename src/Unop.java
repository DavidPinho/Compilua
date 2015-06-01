public class Unop extends Exp {
	public int op;
	public Exp exp;

	public Unop (int op, Exp exp) {
		this.op = op;
		this.exp = exp;
		if (exp != null) exp.setParent(this);
	}
}