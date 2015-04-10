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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
