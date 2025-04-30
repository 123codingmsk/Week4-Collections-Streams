import java.io.*;

public class ByteArrayStream{
	public static void main(String[] a){
	
		String fileip = "aadvika.png";
		String fileop = "out.png";
		
		//it cant directly read the contents from file, so we first
			// using fis, store the bytes in baos
		/* 1. png cant give data using bais, so we extract bytes from it using 
				fis
		*/
		try(FileInputStream fis = new FileInputStream(fileip)){
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			int i;
			while((i = fis.read()) != -1){
				baos.write(i);
			}
			
			byte[] readData = baos.toByteArray();
			System.out.println(readData);
			
			ByteArrayInputStream bais = new ByteArrayInputStream(readData);
			FileOutputStream fos = new FileOutputStream(fileop);
			
			while((i = bais.read()) != -1){
				fos.write(i);
			}
			bais.close();
			fos.close();
			System.out.println("input file copied into output file");
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}