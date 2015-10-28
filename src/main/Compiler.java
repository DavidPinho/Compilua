package main;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import java_cup.runtime.Scanner;
import java_cup.runtime.Symbol;
import lexer.Lexer;
import parser.parser;
import parser.sym;


public class Compiler {

   
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String path = "/home/david/Desktop/exemplo.txt";	
		
		Lexer scanner;
		try {
			scanner = new Lexer(new FileReader(path));
	        
			parser p = new parser(scanner);
			Symbol symbol = p.parse();
			System.out.println(symbol.value);
			
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}
