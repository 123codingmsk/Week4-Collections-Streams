/* 
writeInt, writeDouble, writeBoolean, writeUTF
readInt, readDouble, readBoolean, readUTF
*/
import java.io.*;
public class DataStreams{
	
	public static void writeData(String file){
		try(DataOutputStream dos = new DataOutputStream
			(new FileOutputStream(file))){
			dos.writeInt(40);
			dos.writeUTF("Manoj");
			dos.writeDouble(8.47);
			System.out.println("Data written");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void readData(String file){
		try(DataInputStream dis = new DataInputStream
			(new FileInputStream(file))){
			int num = dis.readInt();
			String name = dis.readUTF();
			double gpa = dis.readDouble();
			
			System.out.println("Num: "+num);
			System.out.println("Name: "+name);
			System.out.println("GPA: "+gpa);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] a){
		String file = "data.dat";
		
		writeData(file);
		readData(file);
	}
}