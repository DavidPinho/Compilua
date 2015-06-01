public class ForExp extends Comando {
	
	public String identifier;
	public Exp exp1;
	public Exp exp2;
	public Exp exp3;
	public Bloco bloco;
	public ListaDeNomes namelist;
	public ListExp explist;

	//for
	public ForExp (String id, Exp exp1, Exp exp2, Exp exp3, Bloco bloco) {
		this.identifier = id;
		this.exp1 = exp1;
		if (exp1 != null) exp1.setParent(this);
		this.exp2 = exp2;
		if (exp2 != null) exp2.setParent(this);
		this.exp3 = exp3;
		if (exp3 != null) exp3.setParent(this);
		this.bloco = bloco;
		if (bloco != null) bloco.setParent(this);
	}

	//foreach
	public ForExp(ListaDeNomes namelist, ListExp explist, Bloco bloco) {
	    this.namelist = namelist;
	    if (namelist != null) namelist.setParent(this);
	    this.explist = explist;
	    if (explist != null) explist.setParent(this);
	    this.bloco = bloco;
	    if (bloco != null) bloco.setParent(this);
	  }
}