package main;
import java.io.FileNotFoundException;
import java.io.FileReader;


import java_cup.runtime.Symbol;
import lexer.Lexer;
import parser.parser;
import tree.Node;


public class Compiler {

   
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//TODO: Alterar Path
		String path = "C:/Users/Diego/Workspace/compilua/src/exemplo.txt";	
		
		Lexer scanner;
		try {
			scanner = new Lexer(new FileReader(path));
	        
			parser p = new parser(scanner);
			Symbol symbol = p.parse();
			
			Node root = (Node) symbol.value;
			
			System.out.println(root);
			//System.out.println(Node.root);
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}
