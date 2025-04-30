import java.io.*;

public class ReadInputConsole{
	public static void main(String[] a){
		BufferedReader br = new BufferedReader
			(new InputStreamReader(System.in));
		
		try{
			System.out.print("Enter name: ");
			String name = br.readLine();
			
			System.out.print("Enter age: ");
			int age = Integer.parseInt(br.readLine());

			System.out.print("Enter language: ");
			String lang = br.readLine();
			
			String file = "console.txt";
			FileWriter fw = new FileWriter(file);
			
			fw.write(name+"\n");
			fw.write(age+"\n");
			fw.write(lang+"\n");
			
			fw.close();
			System.out.println("Data updated into console file");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}