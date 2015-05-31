
public class Node {
	private sym value;
	private Node parent;
	private Node next;
	
	public Node() {
		
	}
	public Node(sym value, Node child, Node next) {
		super();
		this.value = value;
		this.parent = child;
		this.next = next;
	}

	public sym getValue() {
		return value;
	}

	public void setValue(sym value) {
		this.value = value;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	public void print() {
		/*
		System.out.print(" ["+ value);
        child.print();
        System.out.print(", ");
        next.print();
        System.out.println("]");
        */
	}
}
