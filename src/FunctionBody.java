public class FunctionBody extends Node {
	//corpoDaFuncao
	private Node parent;
	private final ParList parlist;
	private final Bloco bloco;

	public FunctionBody(ParList parlist, Bloco bloco) {
		this.parlist = parlist;
		this.bloco = bloco;
	}
}