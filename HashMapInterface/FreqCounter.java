import java.util.Map;
import java.util.HashMap;
import java.io.*;

public class FreqCounter{
	public static void main(String[] a){
		Map<String, Integer> mpp = new HashMap<>();
		String filepath = "names.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
			String line;
			while((line = br.readLine()) != null){
				String[] words = line.split("\\W+");
				for(String word : words){
					int freq = mpp.getOrDefault(word, 0);
					mpp.put(word, freq + 1); 
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.print(mpp);
	}
}