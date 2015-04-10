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
			 //lines = lexicalAnalyzer.readFile("/home/david/workspace/Compilua/src/exemplo.txt");
			 lines = lexicalAnalyzer.readFile("C:/Users/Diego/Workspace/compilua/src/exemplo.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		lines = lexicalAnalyzer.removeComment(lines);
		
		tokensAux=lexicalAnalyzer.splitTokens(lines);				

		tokens = lexicalAnalyzer.doLexAnalysis(tokensAux);
		printTokenList(tokens);
	}
	
	public static void printTokenList(ArrayList<Token> tokens) {
		
		for (Token token : tokens) {
			System.out.println("<"+token.getType()+","+token.getValue()+">");
		}
	}

}
