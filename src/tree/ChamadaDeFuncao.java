package tree;

public class ChamadaDeFuncao extends Exp {
	
	public ChamadaDeFuncao(ListaExp lista, Exp e) {
		
	}
	
	public void cgen() {
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print("(CHAMADA_DE_FUNCAO ");
        left.print();
        System.out.print(", ");
        right.print();
        System.out.print(")");
		
	}
	
	
}
