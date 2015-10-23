package tree;
public class LastReturn extends Node {
	public ListExp explist;

	public LastReturn (ListExp explist) {
		this.explist = explist;
		if (explist != null) explist.setParent(this);
	}
}