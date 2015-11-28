package tree;
public class Comando extends Node {
	
	/*public Comando(String identifier, Exp exp) {
		this.left = new Assign(identifier, exp);
		this.right = null;
	}
	
	//while
	public Comando(Exp e, Bloco b) {
		this.left = new While(e, b);
		this.right = null;
	}*/

	public Comando() {
		
	}
	
	public Comando(IfComando ifcmd, Bloco elseBlock) {
		this.left = ifcmd;
		if (elseBlock != null) {
			this.right = new ElseBloco(elseBlock);
		}
	}
	
	public void cgen() {
		this.left.cgen();
		this.right.cgen();
		
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print("(COMANDO ");
		left.print();
        if(right!=null){
        	System.out.print(", ");
        	right.print();
        }        	
        System.out.print(")");
		
	}
	
	
}