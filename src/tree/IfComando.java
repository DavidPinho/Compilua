package tree;

public class IfComando extends Comando{
	private Bloco esleComando;
	public IfComando(Exp e, Bloco b) {
		this.left = e;
		this.right = b;
		//this.esleComando = b2;
	}
	
	@Override
	public void cgen() {
		// TODO Auto-generated method stub

	}
	@Override
	public void print() {
		System.out.print("(IF ");
		left.print();        
        System.out.print(", ");
        right.print();  
        if(this.esleComando!=null){
            System.out.print(", ");
            System.out.print("(ELSE ");
            this.esleComando.print();
            System.out.print(")");	
          }
        System.out.print(")");       
	}

}
