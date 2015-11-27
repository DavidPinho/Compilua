package tree;

public class ElseBloco extends Bloco {
	
	public ElseBloco(Bloco b) {
		this.left = b;
		this.right = null;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print("(ELSE ");
		if(left!=null){
			left.print();
		    
		} 
	}

}
