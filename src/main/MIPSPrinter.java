package main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

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
	private static ArrayList<String> dataBuffer, textBuffer;
	private static PrintWriter compiluaOut;

	public static void init() {
		dataBuffer = new ArrayList<String>();
		textBuffer = new ArrayList<String>();
		try {
			compiluaOut = new PrintWriter("compilua.out");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void finish() {
		if(!dataBuffer.isEmpty()) {
			compiluaOut.println(".data");
			for (String s : dataBuffer) {
				compiluaOut.println(s);
			}
		}
		compiluaOut.println("");
		compiluaOut.println(".text");
		compiluaOut.println(".globl  main");
		compiluaOut.println("");
		compiluaOut.println("main:");	
		compiluaOut.println("");	
		for (String s : textBuffer) {
			compiluaOut.println(s);
		}
		compiluaOut.println("");
		compiluaOut.println("# exit");
		compiluaOut.println("li $v0, 10");
		compiluaOut.println("syscall ");
		compiluaOut.close();
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
			textBuffer.add(s);
		} else {
			dataBuffer.add(s); //segmento data
		}
	}
	/**
	 * 
	 * @param var
	 * @return true se variavel no segmento texto foi declarada no data, false otherwise
	 */
	public static boolean isVarOnDataSegment(String var) {
		for (Iterator<String> iterator = dataBuffer.iterator(); iterator.hasNext();) {
			String s = (String) iterator.next();
			if(s.equals(var+": .word 0")) {
				return true;
			}
		}
		return false;
	}
}