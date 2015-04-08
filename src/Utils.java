import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class Utils {

	
	
	
	public ArrayList<String> readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        ArrayList<String> linhas= new ArrayList<String>();

	        while (line != null) {
	        	
	        	linhas.add(line);
	        	line = br.readLine();
	        }
	        return linhas;
	    } finally {
	        br.close();
	    }
	}
	
	
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
	
	
}
