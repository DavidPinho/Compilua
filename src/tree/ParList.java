package tree;
public class ParList extends Node {
	//listaPar
	protected ListaDeNomes namelist;
	  protected Boolean varparlist;

	  public ParList (ListaDeNomes namelist, Boolean varparlist) {
	    this.namelist = namelist;
	    this.varparlist = varparlist;
	  }
}