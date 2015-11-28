package parser;

public class CompilerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompilerException(String linha) {
		super("compilação abortada: erro na linha "+linha+" variavel não declarada.");
	}
}
