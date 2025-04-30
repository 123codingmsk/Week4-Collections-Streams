import java.io.*;

public class FileHandling{
	public static void main(String[] a){
		try(FileInputStream fis = new FileInputStream("names.txt")){
            FileOutputStream fos = new FileOutputStream("names-op.txt");
			int i;
			while((i = fis.read()) != -1 ){
				fos.write(i);
			}
			System.out.println("File written into the output file");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}