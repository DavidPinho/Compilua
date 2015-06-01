public class WhileExp extends Comando {
	public Exp exp;
	  public Bloco bloco;

	  public WhileExp (Exp exp, Bloco bloco) {
	    this.exp = exp;
	    if (exp != null) exp.setParent(this);
	    this.bloco = bloco;
	    if (bloco != null) bloco.setParent(this);
	  }
}