import java.io.*;

public class BufferedStreams{
	
	public static void UnbufferedStream(String fileinp, String fileout){
		try(FileInputStream fis = new FileInputStream(fileinp)){
			FileOutputStream fos = new FileOutputStream(fileout);
			int i;
			long startTime = System.nanoTime();
			while((i = fis.read()) != -1){
				fos.write(i);
			}
			long endTime = System.nanoTime();
			System.out.println("FileStream--> File copied into output file in "+
				(endTime - startTime)+" ns");
			fos.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void BufferedStream(String fileinp, String fileout){
		try(BufferedInputStream bis = new BufferedInputStream(
			new FileInputStream(fileinp))){
			
			long startTime = System.nanoTime();
			BufferedOutputStream bos = new BufferedOutputStream
				(new FileOutputStream(fileout));
			int i;
			while((i = bis.read()) != -1){
				bos.write(i);
			}
			long endTime = System.nanoTime();
			System.out.println("BufferedStream--> File copied into output file in "+
				(endTime - startTime)+" ns");
			bos.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] a){
		String fileinp = "aadvika.png";
		String fileout = "aadvika-op.png";
		
		UnbufferedStream(fileinp, fileout);
		BufferedStream(fileinp, fileout);
	}
}