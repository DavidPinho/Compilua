
public class Node {
	private sym value;
	private Node child;
	private Node next;
	
	public Node(sym value, Node child, Node next) {
		super();
		this.value = value;
		this.child = child;
		this.next = next;
	}

	public sym getValue() {
		return value;
	}

	public void setValue(sym value) {
		this.value = value;
	}

	public Node getChild() {
		return child;
	}

	public void setChild(Node child) {
		this.child = child;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
