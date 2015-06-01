public class FunctionCall extends Node {
	public ExpPrefixo preexp;
	public ListExp explist;
	public String name;

	//function call
	public FunctionCall(ExpPrefixo preexp, ListExp explist) {
		this.preexp = preexp;
		if (preexp != null) preexp.setParent(this);
		this.explist = explist;
		if (explist != null) explist.setParent(this);
	}


	//function call self
	public FunctionCall(ExpPrefixo preexp, String name, ListExp explist) {
		this.preexp = preexp;
		if (preexp != null) preexp.setParent(this);
		this.name = name;
		this.explist = explist;
		if (explist != null) explist.setParent(this);
	}
}