public class DoExp extends Exp {
	public Bloco bloco;

	  public DoExp (Bloco bloco) {
	    this.bloco = bloco;
	    if (bloco != null) bloco.setParent(this);
	  }
}