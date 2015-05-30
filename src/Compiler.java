import java.io.IOException;
import java.util.ArrayList;

public class Compiler {

   
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LexicalAnalyzer lexicalAnalyzer =  new LexicalAnalyzer();		
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

		tokens = lexicalAnalyzer.doLexAnalysis(tokensAux);
		
		Parser p = new Parser(lexicalAnalyzer);
		p.parse();
		
		//printTokenList(tokens);
	}
	
	public static void printTokenList(ArrayList<Token> tokens) {
		
		for (Token token : tokens) {
			System.out.println("<"+token.getValue()+","+token.getType()+","+token.getLine()+">");
		}
	}
}
