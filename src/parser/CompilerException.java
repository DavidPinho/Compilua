package parser;

public class CompilerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompilerException(String linha) {
		super("compila��o abortada: erro na linha "+linha+" variavel n�o declarada.");
	}
}
