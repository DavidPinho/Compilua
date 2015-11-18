package main;

public class MIPSPrinter {
	/* TODO: Usar o mesmo arquivo a ser impresso pra facilitar
	 * Usar o metodo init para iniciar o arquivo e funcionar tudo que precise
	 * e o finish pra fechar o arquivo.
	 */

	public static void init() {
		//TODO: implementar
	}
	
	public static void finish() {
		//TODO: implementar
	}
	/**
	 * 
	 * @param s - string com as instrucoes a serem salvas no arquivo de saida
	 * @param segment - d para segmento .data onde sao salvas as declaracoes de variaveis
	 * t para o segmento de texto, onde vao as instrucoes.
	 */
	public static void print(String s, char segment) {
		//TODO: fazer chamada para impressao em arquivo ao inves de console
		if (segment == 't') {
			System.out.println(s); //segmento texto
		} else {
			System.err.println(s); //segmento data
		}
	}
}
