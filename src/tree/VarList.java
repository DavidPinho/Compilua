package tree;
import java.util.Enumeration;
import java.util.Vector;

public class VarList extends Node {
	private final Vector<Var> items;

	public VarList() {
		items = new Vector<>();
	}

	public VarList(Var anItem) {
		this();
		append(anItem);
	}

	public VarList append(Var anItem) {
		if (anItem == null)
			return this;
		anItem.setParent(this);
		items.addElement(anItem);
		return this;
	}

	public Enumeration<Var> elements() {
		return items.elements();
	}

	public Var elementAt(int index) {
		return items.elementAt(index);
	}

	public void setElementAt(Var item, int index) {
		item.setParent(this);
		items.setElementAt(item, index);
	}

	public void insertElementAt(Var item, int index) {
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

	public boolean contains(Var item) {
		int size = items.size();
		for (int i = 0; i < size; i++)
			if (item.equals(items.elementAt(i)))
				return true;
		return false;
	}

	public int indexOf(Var item) {
		return items.indexOf(item);
	}
}