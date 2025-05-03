import java.io.*;

public class LargeFile{
	public static void main(String[] a){
		String file = "names.txt";
		String contain = "error";
		
		try(BufferedReader br = new BufferedReader(new FileReader(file));){
			String line;
			while((line = br.readLine()) != null){
				String[] words = line.split(" ");
				for(String word : words){
					if(word.equals(contain)){
						System.out.println(line);
					}
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}