import java.io.*;

public class PipedStream{
	public static void main(String[] a) throws IOException{
		String file = "names.txt";
		
		PipedOutputStream pos = new PipedOutputStream();
		PipedInputStream pis = new PipedInputStream(pos);
		
		Thread writerThread = new Thread(() -> {
		try {
			String message = "Hello from the writer thread!";
			pos.write(message.getBytes()); 
			pos.close();  
		} catch (IOException e) {
			System.err.println("Writer Thread IOException: " + e.getMessage());
		}
		});
			
		Thread readerThread = new Thread(() -> {
            try {
                int data;
                System.out.print("Reader received: ");
                while ((data = pis.read()) != -1) {
                    System.out.print((char) data);
                }
                pis.close(); 
            } catch (IOException e) {
                System.err.println("Reader Thread IOException: " + e.getMessage());
            }
        });
		
        writerThread.start();
        readerThread.start();
		
	}
}