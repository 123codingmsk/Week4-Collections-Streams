import java.util.*;
import java.io.*;

public class CountWords{

	public static void main(String[] a){
		Map<String, Integer> occ = new HashMap<String, Integer>();
		
		String file = "words.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String line;
			while((line = br.readLine()) != null){
				String[] words = line.split("\\s+");
				for(String word : words){
					int freq = occ.getOrDefault(word, 0);
					occ.put(word, freq + 1);
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
	
		List<Map.Entry<String,Integer>> list = new ArrayList<>(occ.entrySet());
		list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
		
		for(int i=0; i<Math.min(5, list.size()); i++){
			System.out.println(list.get(i).getKey() + ": "+list.get(i).getValue());
		}
		//Collections.sort(moreFreq);
		//System.out.println(moreFreq);
		
	}
}