import java.util.Enumeration;
import java.util.Vector;

public class ListExp extends Node {
	private final Vector<Exp> items;
	private Node parent;

	public ListExp() {
		items = new Vector<>();
	}

	public ListExp(Exp anItem) {
		this();
		append(anItem);
	}

	public ListExp append(Exp anItem) {
		if (anItem == null)
			return this;
		anItem.setParent(this);
		items.addElement(anItem);
		return this;
	}

	public Enumeration<Exp> elements() {
		return items.elements();
	}

	public Exp elementAt(int index) {
		return items.elementAt(index);
	}

	public void setElementAt(Exp item, int index) {
		item.setParent(this);
		items.setElementAt(item, index);
	}

	public void insertElementAt(Exp item, int index) {
		item.setParent(this);
		items.insertElementAt(item, index);
	}

	public void removeElementAt(int index) {
		items.removeElementAt(index);
	}

	public int size() {
		return items.size();
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}

	public boolean contains(Exp item) {
		int size = items.size();
		for (int i = 0; i < size; i++)
			if (item.equals(items.elementAt(i)))
				return true;
		return false;
	}

	public int indexOf(Exp item) {
		return items.indexOf(item);
	}
}