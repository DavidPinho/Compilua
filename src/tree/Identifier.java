package tree;

public class Identifier extends Node {
	public Identifier(String id) {
		this.value = id;
	}
	
	public void cgen() {
		//TODO: fazer o codigo MIPS32 pra mostrar o valor
	}
	
	public String getValue() {
		return this.value;
	}
}