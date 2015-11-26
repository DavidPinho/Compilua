package tree;

public class ChamadaDeFuncao extends Comando {
	
	public ChamadaDeFuncao(String identifier) {
		this.left=new Identifier(identifier);
		this.right=null;
	}
	
	public ChamadaDeFuncao(String identifier, ExpList list) {
		this.left=new Identifier(identifier);
		this.right=list;
	}
	
	public void cgen() {
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print("(CHAMADA_DE_FUNCAO ");
        left.print();
        if(this.right!=null){
	        System.out.print(", ");
	        right.print();
        }
        System.out.print(")");
		
	}
	
	
}
