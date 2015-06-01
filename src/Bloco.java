public class Bloco extends Node {
	private Node parent;
	public Trecho trecho1;
	public Trecho trecho2;

	public Bloco(Trecho trecho1, Trecho trecho2) {
		this.trecho1 = trecho1;
		if (trecho1 != null)
			trecho1.setParent(this);
		this.trecho2 = trecho2;
		if (trecho2 != null)
			trecho2.setParent(this);
	}
}