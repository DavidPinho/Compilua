package tree;
public class FunctionExp extends Exp {

  public ListaDeNomes args;
  public boolean hasArgs;
  public Bloco bloco;

  public FunctionExp (ListaDeNomes args, boolean hasArgs, Bloco bloco) {
    this.args = args;
    if (args != null) args.setParent(this);
    this.hasArgs = hasArgs;
    this.bloco = bloco;
    if (bloco != null) bloco.setParent(this);
  }
}