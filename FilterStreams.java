import java.io.*;

public class FilterStreams{
	public static void main(String[] a){
		String inpfile = "names.txt";
		String opfile = "namesup.txt";
		
		try(FileReader fr = new FileReader(inpfile);
			FileWriter fw = new FileWriter(opfile)){
				
			BufferedReader br = new BufferedReader(fr);
			BufferedWriter bw = new BufferedWriter(fw);
			
			String line;
			while((line = br.readLine()) != null){
				bw.write(line.toUpperCase());
				bw.newLine();
			}
			br.close();
			bw.close();
			System.out.println("Converted everything inside names file toUpperCase");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}