package tree;
public class IfThenElse extends Comando {
	public Exp ifexp;
	public Bloco Then;
	public Bloco Else;

	public IfThenElse (Exp ifexp, Bloco thenbloco, Bloco elsebloco) {
		this.ifexp = ifexp;
		if (ifexp != null) ifexp.setParent(this);
		this.Then = thenbloco;
		if (thenbloco != null) thenbloco.setParent(this);
		this.Else = elsebloco;
		if (elsebloco != null) elsebloco.setParent(this);
	}
}