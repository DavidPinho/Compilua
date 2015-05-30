import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Scanner;
import java_cup.runtime.Symbol;
import java_cup.runtime.SymbolFactory;

public class LexicalAnalyzer implements Scanner{
	// attribute to record line numbers
	private static ArrayList<Integer> lineNumbers;
	private static LinkedList<Token> tokens;
	private static SymbolFactory sf = new ComplexSymbolFactory();
	private static String fileToRead;
	
	
	public LexicalAnalyzer(String args){
		LexicalAnalyzer.fileToRead=args;
	}
		
	//method to read a file and return an Array of String, where each String is a line of the file
	public static ArrayList<String> readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    lineNumbers = new ArrayList<Integer>();
	    int lineNumber = 1;
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        ArrayList<String> lines= new ArrayList<String>();

	        while (line != null) {
	        	lines.add(line);
	        	line = br.readLine();
	        	lineNumbers.add(lineNumber);
	        	lineNumber++;
	        }
	        return lines;
	    } finally {
	        br.close();
	    }
	}
	
	
	//This method remove all comments in the code
	@SuppressWarnings("unchecked")
	public static ArrayList<String> removeComment(ArrayList<String> lines){
		
		boolean block = false;
		
		ArrayList<String> linesAux = (ArrayList<String>) lines.clone();
		
		for(int i=0; i<linesAux.size();i++){
			String line = linesAux.get(i);
			if(line.startsWith("--[[")){
				block = true;	
				lines.remove(line);
				lineNumbers.remove(i);
			}else if(line.contains("--]]")){
				block =false;
				int index = line.lastIndexOf("--]]");
				index = index + 4;
				if(line.length()>index)
					line = line.substring(index, line.length());
				else {
					lines.remove(line);
					lineNumbers.remove(i);
				}
			}else if(line.startsWith("--")){
				lines.remove(line);
				}else if(block) {
					lines.remove(line);
					lineNumbers.remove(i);
				}
		}		
		return lines;			
	}
	
	
	
	public static ArrayList<String> splitTokens(ArrayList<String> lines){
		
		ArrayList<String> tokens = new ArrayList<String>();
		String [] aux;
		String tokenAux;	
		String stringAux="";
		String openPattern="";
		String closePattern="";
		boolean doubleQuota = false;
		boolean singleQuota = false;
		boolean firstOpenBracket =false;		
		boolean stringBool=false;
		
	
		for(String line: lines){					
			
			aux =  line.trim().split("(((?<=\\s+)|(?=\\s+))|" +
									 "((?<=,)|(?=,))|" +
									 "((?<==)|(?==))|" +
									 "((?<=\\+)|(?=\\+))|" +
									 "((?<=-)|(?=-))|" +
									 "((?<=\\*)|(?=\\*))|" +
									 "((?<=/)|(?=/))|" +
									 "((?<=%)|(?=%))|" +
									 "((?<=^)|(?=^))|" +
									 "((?<=#)|(?=#))|" +
									 "((?<=~)|(?=~))|" +
									 "((?<=>)|(?=>))|" +
									 "((?<=<)|(?=<))|" +
									 "((?<=\\()|(?=\\())|" +
									 "((?<=\\))|(?=\\)))|" +
									 "((?<=\\{)|(?=\\{))|" +
									 "((?<=\\})|(?=\\}))|" +
									 "((?<=\\[)|(?=\\[))|" +         
									 "((?<=\\])|(?=\\]))|" +
									 "((?<=;)|(?=;))|" +
									 "((?<=:)|(?=:))|" +
									 "((?<=\")|(?=\"))|" +									 
									 "((?<=\')|(?=\'))|" +
									 "((?<=\\.)|(?=\\.)))" +								 
									 "");
			
			//LOOKAHEAD
			//The follow code aim to solve possible problems caused by the split operation. 
			//For example, we used "=" as a delimiter, but there are different expressions that use the operator "="  (<=, >=,==, =)
			//So, we make sure that the code was splited correctly
			for(int j = 0; j<aux.length;j++){
				 tokenAux= aux[j];
				 
				 if(tokenAux.equals("[") || tokenAux.equals("]") || tokenAux.equals("=")){
					 if(doubleQuota || singleQuota){
						 stringAux=stringAux+tokenAux;
					 }else  
						 if(tokenAux.equals("[")){
							 if(stringBool){
								 stringAux=stringAux+tokenAux;
							 }else
								 if(!firstOpenBracket){
									 if(j+1<aux.length){
										 if(aux[j+1].equals("[") || aux[j+1].equals("=")){
											 stringAux = stringAux + tokenAux;
											 firstOpenBracket=true;
										 }
										 else{
											 tokens.add(tokenAux);
										 }
									 }else{
										 tokens.add(tokenAux);
									 }
								 }else{
									 stringAux = stringAux + tokenAux;
									 stringBool=true;
									 firstOpenBracket=false;
									 openPattern= openPattern+stringAux;
								 }
						 }else
							 if(tokenAux.equals("=")){
								 if(stringBool){
									 stringAux=stringAux+tokenAux;
									 if(!closePattern.equals("")&&(aux[j+1].equals("=")||aux[j+1].equals("]"))){
										 closePattern=closePattern+tokenAux;
									 }
								 }else
									 if(firstOpenBracket){
										 stringAux=stringAux+ tokenAux;
									 }else
										 if(aux[j+1].equals("=")){
					  				  		   tokens.add("==");
					  				  		   j++;
					  				  	   }else{
					  				  		   tokens.add("=");
					  				  	  }
							 }else
								 if(tokenAux.equals("]")){
									 if(stringBool){
										 stringAux=stringAux+tokenAux;
										 closePattern=closePattern+tokenAux;
										 if(matchPatterns(openPattern, closePattern)){
											 tokens.add(stringAux);
											 stringBool=false;
											 stringAux=new String();
											 openPattern="";
											 closePattern="";											 
										 }else
										 	 if(j+1<aux.length){
										 		 if(!(aux[j+1].equals("=")||aux[j+1].equals("]")))
										 		 	closePattern="";
										 	 }
									 }else{
										 tokens.add(tokenAux);
									 }
								 }
				 }else	
					 if(tokenAux.equals("\"")){			
					    if(doubleQuota){  
					    	if(stringAux.endsWith("\\")){               //Identify an quote(") inside of "
					    		stringAux = stringAux + tokenAux;
					    	}else{										
					    		stringAux = stringAux + tokenAux;		//Identify end of string
					    	 	tokens.add(stringAux);
					    	 	stringAux=new String();
					    	 	doubleQuota=false;
					    	}
					    }else if(singleQuota || stringBool){							//Identify the begin of a string (The first quote ("))
					    		stringAux = stringAux + tokenAux;
					    	   }else{
					    		  doubleQuota=true;
					    		  stringAux = stringAux + tokenAux;
					    	  }				    							
					  }else 					  
						  
						  if(tokenAux.equals("\'")){							
							    if(singleQuota){   
							    	if(stringAux.endsWith("\\")){			//Identify an single quote(') inside of '
							    		stringAux = stringAux + tokenAux;
							    	}else{
							    		stringAux = stringAux + tokenAux;  //Identify end of string
							    		tokens.add(stringAux);
								    	stringAux=new String();
								    	singleQuota=false;
							    	}							    	
							    }else if(doubleQuota || stringBool){
							    		stringAux = stringAux + tokenAux;   //Identify a single quote inside a quote
							    	  }
							    	  else{
							    		stringAux = stringAux + tokenAux;
							    		singleQuota=true;		 		    //Identify the begin of a string (The first single quote ('))
							    	  }
					  		}else				  			
					  			
					  			if(stringBool||doubleQuota||singleQuota){		  			   
					  			    	stringAux = stringAux + tokenAux;
					  			}else 
					  				
					  				if(tokenAux.trim().equals(""))		
					  					continue;
					  				else			  				
						  				if(tokenAux.equals("~")){
						  				  	   if(aux[j+1].equals("=")){
						  				  		   tokens.add("~=");
						  				  		   j++;
						  				  	   }else{
						  				  		   tokens.add("~");
						  				  	   }				  				  		   
						  			  	}else
						  			  		
							  			  	if(tokenAux.equals("<")){
							  				  	   if(aux[j+1].equals("=")){
							  				  		   tokens.add("<=");
							  				  		   j++;
							  				  	   }else{
							  				  		   tokens.add("<");
							  				  	   }				  				  		   
							  			  	}else
							  			  		
								  			  	if(tokenAux.equals(">")){
								  				  	   if(aux[j+1].equals("=")){
								  				  		   tokens.add(">=");
								  				  		   j++;
								  				  	   }else{
								  				  		   tokens.add(">");
								  				  	   }				  				  		   
								  			  	}else					  			  		
								  			  		if(tokenAux.equals(".")){
								  			  			
									  			  		Pattern p = Pattern.compile(
									  						    "[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)" +
									  						    	    "([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|" +
									  						    	    "(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))" +
									  						    	    "[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*");//number
									  			  		Matcher m1 = p.matcher("."); //only to initialize
									  			  	    Matcher m2 = p.matcher("."); //only to initialize
									  					if(j-1>=0)
									  					  m1 = p.matcher(aux[j-1]);
									  					if(j+1<aux.length)
									  					  m2 = p.matcher(aux[j+1]);
								  			  			if(m1.matches()&& m2.matches()){     //NUMBER
								  			  				tokens.remove(tokens.size()-1);
								  			  				tokens.add(aux[j-1]+tokenAux+aux[j+1]);
								  			  				j++;
								  			  			}else{ 
								  			  				if(aux.length>j+1){			//3 DOTS (...)
								  			  					if(aux.length>j+2){
								  			  						if(aux[j+1].equals(".")&&aux[j+2].equals(".")){
								  			  							tokens.add("...");
								  			  							j=j+2;
								  			  						}else if(aux[j+1].equals(".")){    //2 DOTS (..)
									  			  							tokens.add("..");
									  			  							j++;
								  			  							  }else{
								  			  								  tokens.add(".");
								  			  							  }
								  			  					}else{
								  			  					if(aux[j+1].equals(".")){    //2 DOTS (..)
							  			  							tokens.add("..");
							  			  							j++;
							  			  						}
								  			  					}
								  			  				  }else{
								  			  					  tokens.add(".");
								  			  				  }
								  			  			}								  			  				
								  			  		}else{
								  			  			tokens.add(tokenAux);	//OTHERWISE
								  			  		 }						
				}				
			tokens.add("\\n");	//NEW LINE		
		}				
		return tokens;		
	}
	

	
	
	public static LinkedList<Token> doLexAnalysis(ArrayList<String> tokensArray) {
		LinkedList<Token> lexemes = new LinkedList<Token>();
		LinkedList<String> tokens = new LinkedList<String>();
		Token t;
		
		//tokens.removeAll(Collections.singleton(null));
		tokens = removeNullElements(tokensArray);
		for(int i = 0; i <tokens.size(); i++) {
			t = new Token(getTokenType(tokens.get(i)), tokens.get(i));

			lexemes.add(t);
		}
		LexicalAnalyzer.tokens = lexemes;
		return lexemes;
	}
	
	
	public static TokenType getTokenType(String word) {
		TokenType type = null;
		Pattern p = Pattern.compile(
			    "[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)" +
			    	    "([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|" +
			    	    "(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))" +
			    	    "[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*");//number
		Matcher m = p.matcher(word);
		
		p = Pattern.compile("^\\[=*\\[");
		Matcher m2 = p.matcher(word);
		if(word.contains("'") || word.contains("\"")) {
			type = TokenType.STRING;
		} else if(m2.matches()) {
			type = TokenType.STRING;
		} else if(m.matches()) {
			type = TokenType.NUMBER;
		} else if(word.equals("(")) {
			type = TokenType.LPAREN;
		} else if(word.equals(")")) {
			type = TokenType.RPAREN;
		} else if(word.equals("{")) {
			type = TokenType.LBRACE;
		} else if(word.equals("}")) {
			type = TokenType.RBRACE;
		} else if(word.equals("[")) {
			type = TokenType.LBRACKET;
		} else if(word.equals("]")) {
			type = TokenType.RBRACKET;
		} else if(word.equals(";")) {
			type = TokenType.SEMICOLON;
		} else if(word.equals(":")) {
			type = TokenType.COLON;
		} else if(word.equals(",")) {
			type = TokenType.COMA;
		} else if(word.equals(".")) {
			type = TokenType.DOT;
		} else if(word.equals("..")) {
			type = TokenType.TWODOTS;
		} else if(word.equals("...")) {
			type = TokenType.THREEDOTS;
		} else if(word.equals("+")) {
			type = TokenType.PLUS_OP;
		} else if(word.equals("-")) {
			type = TokenType.MINUS_OP;
		} else if(word.equals("==")) {
			type = TokenType.EQUALS_OP;
		} else if(word.equals("~=")) {
			type = TokenType.DIFFERENT_OP;
		} else if(word.equals("*")) {
			type = TokenType.TIMES_OP;
		} else if(word.equals("/")) {
			type = TokenType.SLASH_OP;
		} else if(word.equals("%")) {
			type = TokenType.PERCENT_OP;
		} else if(word.equals("^")) {
			type = TokenType.POT_OP;
		} else if(word.equals("#")) {
			type = TokenType.HASH_OP;
		} else if(word.equals("<=")) {
			type = TokenType.LESSEQUALS_OP;
		} else if(word.equals(">=")) {
			type = TokenType.MOREEQUALS_OP;
		} else if(word.equals("<")) {
			type = TokenType.LESS_OP;
		} else if(word.equals(">")) {
			type = TokenType.MORE_OP;
		} else if(word.equals("=")) {
			type = TokenType.ASSIGN_OP;
		} else if(word.equals("and")) {
			type = TokenType.AND_KWORD;
		} else if(word.equals("end")) {
			type = TokenType.END_KWORD;
		} else if(word.equals("in")) {
			type = TokenType.IN_KWORD;
		} else if(word.equals("repeat")) {
			type = TokenType.REPEAT_KWORD;
		} else if(word.equals("break")) {
			type = TokenType.BREAK_KWORD;
		} else if(word.equals("false")) {
			type = TokenType.FALSE_KWORD;
		} else if(word.equals("local")) {
			type = TokenType.LOCAL_KWORD;
		} else if(word.equals("return")) {
			type = TokenType.RETURN_KWORD;
		} else if(word.equals("do")) {
			type = TokenType.DO_KWORD;
		} else if(word.equals("for")) {
			type = TokenType.FOR_KWORD;
		} else if(word.equals("nil")) {
			type = TokenType.NIL_KWORD;
		} else if(word.equals("then")) {
			type = TokenType.THEN_KWORD;
		} else if(word.equals("else")) {
			type = TokenType.ELSE_KWORD;
		} else if(word.equals("function")) {
			type = TokenType.FUNCTION_KWORD;
		} else if(word.equals("not")) {
			type = TokenType.NOT_KWORD;
		} else if(word.equals("true")) {
			type = TokenType.TRUE_KWORD;
		} else if(word.equals("elseif")) {
			type = TokenType.ELSEIF_KWORD;
		} else if(word.equals("if")) {
			type = TokenType.IF_KWORD;
		} else if(word.equals("or")) {
			type = TokenType.OR_KWORD;
		} else if(word.equals("until")) {
			type = TokenType.UNTIL_KWORD;
		} else if(word.equals("while")) {
			type = TokenType.WHILE;
		} else if(word.equals("\\n")) {
			type = TokenType.NEWLINE;
		} else type = TokenType.IDENTIFIER;//otherwise
		return type;
	}
	
	
	
	public static boolean matchPatterns(String open, String close){
		if(open.length()==close.length()){
			for(int i =0; i<open.length();i++){
				if(open.charAt(i)=='['){
					if(close.charAt(i)==']')
						continue;
					else
						return false;
				}else 
					if((open.charAt(i)=='=')&&(close.charAt(i)=='='))
						continue;
					else
						return false;
				
			}
			
		}else{
			return false;
		}
		
		return true;
	}
	
	
	public static void init() throws java.io.IOException        { 
		System.out.println("Entrou no init");
		ArrayList<String> lines  = new ArrayList<String>();	
		ArrayList<String> tokensAux  = new ArrayList<String>();	
		
		try {
			 lines = readFile(fileToRead);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		lines = removeComment(lines);
		
		tokensAux=splitTokens(lines);				

		LexicalAnalyzer.tokens = doLexAnalysis(tokensAux);		
		
	}
	
	/**
	 * Called to return the next token of the list.
	 * when a Token is readed, it is removed from the original list and transformed in a Symbol.
	 * @return a new symbol
	 */
	public static Symbol nextToken() {
		int i = 0;
		System.out.println("Entrou no nextToken");
		if(!tokens.isEmpty()) {
			System.out.println("!tokens.isEmpty()");
			Token token = tokens.getFirst();			
			tokens.remove(token);// tira da lista pra poder funcionar o nextToken
			System.out.println("token removido: " + token.getType() + " "+token.getValue());
			for(i = 0; i < tokens.size(); i++) {
			    if(sym.terminalNames[i].equals(token.getType().name())) {
			       return sf.newSymbol(""+token.getType(),i,token.getValue());
			    }
			   }			
		} else {
			System.out.println("tokens  is Empty");
			return sf.newSymbol("EOF",sym.EOF);
		}
		return null;
	}

	@Override
	public Symbol next_token() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Entrou no next_token");
		return null;
	}
	
	public static LinkedList<String> removeNullElements(ArrayList<String> tokensArray) {
		LinkedList<String> aux = new LinkedList<String>();
		
		for(String s : tokensArray) {
			if(!s.equals("null")) {
				aux.add(s);
			}
		}
		
		return aux;
	}
	
	
	
	
}
