import java.util.Enumeration;
import java.util.Vector;

public class Trecho extends Node {
	//trecho
	
	//trecho1
	private final Vector<Comando> items;
	private Node parent;

	public Trecho() {
		items = new Vector<>();
	}

	public Trecho(Comando anItem) {
		this();
		append(anItem);
	}

	public Trecho append(Comando anItem) {
		if (anItem == null)
			return this;
		anItem.setParent(this);
		items.addElement(anItem);
		return this;
	}

	public Enumeration<Comando> elements() {
		return items.elements();
	}

	public Comando elementAt(int index) {
		return items.elementAt(index);
	}

	public void setElementAt(Comando item, int index) {
		item.setParent(this);
		items.setElementAt(item, index);
	}

	public void insertElementAt(Comando item, int index) {
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

	public boolean contains(Comando item) {
		int size = items.size();
		for (int i = 0; i < size; i++)
			if (item.equals(items.elementAt(i)))
				return true;
		return false;
	}

	public int indexOf(Comando item) {
		return items.indexOf(item);
	}
	
	//trecho2
}