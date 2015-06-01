public class VarTabIndex extends Var {
	public ExpPrefixo preexp;
	public Exp indexexp;

	public VarTabIndex (ExpPrefixo preexp, Exp indexexp) {
		this.preexp = preexp;
		if (preexp != null) preexp.setParent(this);
		this.indexexp = indexexp;
		if (indexexp != null) indexexp.setParent(this);
	}
}