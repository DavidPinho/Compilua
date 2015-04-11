import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LexicalAnalyzer {

	
	
	//method to read a file and return an Array of String, where each String is a line of the file
	public ArrayList<String> readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        ArrayList<String> lines= new ArrayList<String>();

	        while (line != null) {
	        	
	        	lines.add(line);
	        	line = br.readLine();
	        }
	        return lines;
	    } finally {
	        br.close();
	    }
	}
	
	
	//This method remove all comments in the code
	public ArrayList<String> removeComment(ArrayList<String> lines){
		
		boolean block = false;
		
		ArrayList<String> linesAux = (ArrayList<String>) lines.clone();
		
		for(int i=0; i<linesAux.size();i++){
			String line = linesAux.get(i);
			if(line.startsWith("--[[")){
				block = true;	
				lines.remove(line);			
			}else if(line.contains("--]]")){
				block =false;
				int index = line.lastIndexOf("--]]");
				index = index + 4;
				if(line.length()>index)
					line = line.substring(index, line.length());
				else
					lines.remove(line);				
			}else if(line.startsWith("--")){
				lines.remove(line);
				}else if(block)
					lines.remove(line);			
		}		
		return lines;			
	}
	
	
	
	public ArrayList<String> splitTokens(ArrayList<String> lines){
		
		ArrayList<String> tokens = new ArrayList<String>();
		String [] aux;
	
		for(String line: lines){					
			
			aux =  line.trim().split("(\\s+|" +
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
			
			lookAhead(aux, tokens);
		}	
		
		
		for(String t : tokens)
			System.out.println(t);
		
		return tokens;
	
		
	}
	
	/* TODO: estamos com um problema quando eh string
	 * temos que reconhecer quando abrir " ou ', ta dando o split de boa
	 * mas ta adicionando um espaco depois da aspa, temos que fazer algo do tipo:
	 * 
	 * para o primeiro elemento depois da aspa ele nao gera aquele espaco que vc ta gerando pra concatenar
	 * 
	 * ta assim:
	 * "value of a:"
	 * 
	 * e na saida
	 * 
	 * " value of a :"
	 */
	
	public void lookAhead(String[] aux, ArrayList<String> tokens){
		
		String tokenAux;
		String stringAux="";
		boolean doubleQuota = false;
		boolean singleQuota = false;
		
		//The follow code aim to solve possible problems caused by the split operation. 
		//For example, we used "=" as a delimiter, but there are different expressions that use the operator "="  (<=, >=,==, =)
		//So, we make sure that the code was splited correctly
		for(int j = 0; j<aux.length;j++){
			 tokenAux= aux[j].trim();			 
		
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
			    }else if(singleQuota){							//Identify the begin of a string (The first quote ("))
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
					    }else if(doubleQuota){
					    		stringAux = stringAux + tokenAux;   //Identify a single quote inside a quote
					    	  }
					    	  else{
					    		stringAux = stringAux + tokenAux;
					    		singleQuota=true;		 		    //Identify the begin of a string (The first single quote ('))
					    	  }
			  		}else				  			
			  			
			  			if(doubleQuota||singleQuota){		  			   
			  			    	stringAux = stringAux + " "+ tokenAux;
			  			}else 
			  				
			  				if(tokenAux.equals(""))		
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
						  			  		
							  			  	if(tokenAux.equals("=")){
							  				  	   if(aux[j+1].equals("=")){
							  				  		   tokens.add("==");
							  				  		   j++;
							  				  	   }else{
							  				  		   tokens.add("=");
							  				  	   }				  				  		   
							  			  	}else
							  			  		
							  			  		if(tokenAux.equals(".")){
							  			  			if(aux[j-1].matches("[0-9]+")){     //FLOAT NUMBER
							  			  				tokens.remove(tokens.size()-1);
							  			  				tokens.add(aux[j-1]+tokenAux+aux[j+1]);
							  			  				j++;
							  			  			}else{ 
							  			  				if(aux.length>j+1){			//3 DOTS (...)
							  			  					if(aux.length>j+2){
							  			  						if(aux[j+1].equals(".")&&aux[j+2].equals(".")){
							  			  							tokens.add("...");
							  			  							j=j+2;
							  			  						}
							  			  					}else{
							  			  					if(aux[j+1].equals(".")){    //2 DOTS (..)
						  			  							tokens.add("..");
						  			  							j++;
						  			  						}
							  			  					}
							  			  				  }
							  			  			}
							  			  				
							  			  		}else{
							  			  			tokens.add(tokenAux);	//OTHERWISE
							  			  		 }						
		}				
		tokens.add("\\n");		
	}
	
	
	public ArrayList<Token> doLexAnalysis(ArrayList<String> tokens) {
		ArrayList<Token> lexemes = new ArrayList<Token>();
		Token t;
		
		for(int i = 0; i < tokens.size(); i++) {
			t = new Token(getTokenType(tokens.get(i)), tokens.get(i));
			lexemes.add(t);
		}
		
		return lexemes;
	}
	
	
	public TokenType getTokenType(String word) {
		TokenType type = null;
		Pattern p = Pattern.compile(
			    "[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)" +
			    	    "([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|" +
			    	    "(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))" +
			    	    "[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*");//number
		Matcher m = p.matcher(word);
		if(word.contains("'") || word.contains("\"")) {
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
	
	
	
	
	
	
	
	
}
