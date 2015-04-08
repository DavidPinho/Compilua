import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.IOException;
import java.util.ArrayList;

public class LexicalAnalyzer {



	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileHandler fileHandler =  new FileHandler();		
		String code = "";
		
		try {
			 code = fileHandler.readFile("/home/david/workspace/Compilua/src/exemplo.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		
		ArrayList<Token> tokens = new ArrayList<Token>();
		char c;
		//Automato
		for(int i =0; i<code.length();i++){
			c = code.charAt(i);
			
			
			
		}
		
		
		
		

	}
	
	
	

}
