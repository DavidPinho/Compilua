import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class FileHandler {

	
	
	
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
	
	
}
