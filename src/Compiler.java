import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import java_cup.runtime.Scanner;


public class Compiler {

   
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*LexicalAnalyzer lexicalAnalyzer =  new LexicalAnalyzer();		
		ArrayList<String> lines  = new ArrayList<String>();	
		ArrayList<String> tokensAux  = new ArrayList<String>();	
		ArrayList<Token> tokens = new ArrayList<Token>();		
		
		try {
			 lines = lexicalAnalyzer.readFile(args[0]);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		
		lines = lexicalAnalyzer.removeComment(lines);																																																																																																																																																																																																																																																					
																																															
		tokensAux=lexicalAnalyzer.splitTokens(lines);				
																																																																																							
		tokens = lexicalAnalyzer.doLexAnalysis(tokensAux);*/
		
		//String path =  new LexicalAnalyzer("/home/david/workspace/Compilua/src/exemplo.txt";
		//String path = args;
		String path = "C:/Users/Diego/Workspace/compilua/src/exemplo.txt";	
		
		Lexer scanner = new Lexer(new StringReader(path));
		parser p = new parser(scanner);

		try {
			System.out.println(p.parse().value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//printTokenList(tokens);
	}
	
	/*public static void printTokenList(ArrayList<Token> tokens) {
		
		for (Token token : tokens) {
			System.out.println("<"+token.getValue()+","+token.getType()+","+token.getLine()+">");
		}
	}*/
}
