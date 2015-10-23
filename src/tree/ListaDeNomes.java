package tree;
import java.util.Enumeration;
import java.util.Vector;

public class ListaDeNomes extends Node {
	private final Vector<Identifier> items;

	public ListaDeNomes() {
		items = new Vector<>();
	}

	public ListaDeNomes(Identifier anItem) {
		this();
		append(anItem);
	}

	public ListaDeNomes append(Identifier anItem) {
		if (anItem == null)
			return this;
		anItem.setParent(this);
		items.addElement(anItem);
		return this;
	}

	public Enumeration<Identifier> elements() {
		return items.elements();
	}

	public Identifier elementAt(int index) {
		return items.elementAt(index);
	}

	public void setElementAt(Identifier item, int index) {
		item.setParent(this);
		items.setElementAt(item, index);
	}

	public void insertElementAt(Identifier item, int index) {
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

	public boolean contains(Identifier item) {
		int size = items.size();
		for (int i = 0; i < size; i++)
			if (item.equals(items.elementAt(i)))
				return true;
		return false;
	}

	public int indexOf(Identifier item) {
		return items.indexOf(item);
	}
}