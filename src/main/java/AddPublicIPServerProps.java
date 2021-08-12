import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class AddPublicIPServerProps {
	public static void main(String[] args) {
		//File file = new File("/kafka_2.13-2.7.0/config/server.properties");
        File homedir = new File(System.getProperty("java.class.path"));
        
        //File file = new File(homedir, "/kafka_2.13-2.7.0/config/server.properties");
        File file = new File(homedir, "/kafka_2.12-2.8.0/config/server.properties");
		
		getLineValuefromLineNo(file,args[0]);
			 
	}

	public static String getLineValuefromLineNo(File file, String pubicIP) {
		BufferedReader br = null;
		
		
		try {
			br = new BufferedReader(new FileReader(file));
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String seqString = new String();
		int lineNo= 0;
		Map<Integer, String> linesInMap = new HashMap<Integer, String>();

		try {
			
			
			while (br.ready()) {
				seqString = br.readLine();
				if(seqString.startsWith("advertised.listeners")) {
					seqString= "advertised.listeners=PLAINTEXT://"+pubicIP+":9092";
				}
				//System.out.println(seqString);
				linesInMap.put(lineNo++,seqString);
			}
			
			File fout = new File(file.getAbsolutePath());
			FileOutputStream fos = new FileOutputStream(fout);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

			
			for (Map.Entry printData : linesInMap.entrySet()) {
				//System.out.println(printData.getValue());
				bw.write((String) printData.getValue());
				bw.newLine();
			}
			bw.close();
			fos.close();
			
			
			
		} catch (IOException e) {

			e.printStackTrace();
		}

		return seqString;
	}
}
