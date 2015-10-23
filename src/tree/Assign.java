package tree;
public class Assign extends Node {

	public VarList varlist;
	public ListExp explist;


	public Assign(VarList varlist, ListExp explist) {
		this.varlist = varlist;
		if (varlist != null) varlist.setParent(this);
		this.explist = explist;
		if (explist != null) explist.setParent(this);
	}
}