package tree;

public abstract class Node {
	protected String value;
	protected Node left;
	protected Node right;
	public static Node root = null;
	

	public String getValue() {
		return value;
	}

	public abstract void cgen();
	
	public abstract void print();
}