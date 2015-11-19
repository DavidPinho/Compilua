package main;

public class MIPSPrinter {
	/* TODO: Usar o mesmo arquivo a ser impresso pra facilitar
	 * Usar o metodo init para iniciar o arquivo e funcionar tudo que precise
	 * e o finish pra fechar o arquivo.
	 * 
	 * TODO: usar uma estrutura talvez como um String[] pra armazenar o ccodigo gerado num buffer
	 * ai no metodo finish varre o buffer e imprime no arquivo, fechando o mesmo sequencialmente.
	 * 
	 * A ideia do buffer eh pq no assembly tem o segmento .data pra gdeclaracao de variaveis
	 * e isso pode ficar baguncado na geracao. sugiro o buffer do data e do text ai gravamos no arquivo o do
	 * data e depois o do text, acho que fica mais facil.
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