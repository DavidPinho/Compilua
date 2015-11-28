package tree;

import parser.CompilerException;
import main.MIPSPrinter;

public class Assign extends Comando {


	public Assign(String id, Exp exp) {
		this.left = new Identifier(id);
		this.right = exp;
	}
	
	@Override
	public void cgen() {
		String var = ((Identifier) this.left).getValue();
		this.right.cgen();// Load Number li $a0 number
		//atribuicao do valor da exp na variavel
		
		if (MIPSPrinter.isVarOnDataSegment(var)) {
			MIPSPrinter.print("sw $a0, " + var,
					't');
		} else {
			throw new CompilerException("linha"); //TODO: implementar linhas
		}
	}

	@Override
	public void print() {
		System.out.print("(ASSIGNMENT ");
		this.left.print();
		System.out.print(",");
        this.right.print();
        System.out.print(")");
		
	}
}