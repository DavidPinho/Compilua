package tree;

public class ListaExp extends Node {

	@Override
	public void cgen() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print("(LISTA_EXP ");
        left.print();
        System.out.print(", ");
        right.print();
        System.out.print(")");
		
	}

}
