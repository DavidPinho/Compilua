import java.io.IOException;
import java.util.ArrayList;

public class LexicalAnalyzer {

   
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Utils utils =  new Utils();		
		ArrayList<String> linhas  = new ArrayList<String>();	
		ArrayList<Token> tokens = new ArrayList<Token>();
		
		
		try {
			 linhas = utils.readFile("/home/david/workspace/Compilua/src/exemplo.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		linhas = utils.removeComment(linhas);
		for(int i =0; i<linhas.size();i++){
			
			String linha =  linhas.get(i);
			System.out.println(linha);
		}
		
		/*
		//Automato
		for(int i =0; i<linhas.size();i++){
				
			String linha =  linhas.get(i);
			String [] test =  linha.split("((?<==)|(?==)| (?<=:)|(?=:))");
			
			for(int j = 0; j<test.length;j++)
				System.out.println(test[j].trim());
				
			break;
		}
		*/
		
		
	
		

	}
	
	
	

}
