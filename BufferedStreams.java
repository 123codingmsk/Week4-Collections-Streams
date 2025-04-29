import java.io.*;

public class BufferedStreams{
	public static void main(String[] a){
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("names.txt"));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("output.txt"))){
			
			byte[] arr = new byte[1024];
			int bytesRead;
			while((bytesRead = bis.read(arr)) != -1){
				bos.write(arr, 0, bytesRead);
			}
			System.out.println("File copied into output");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}