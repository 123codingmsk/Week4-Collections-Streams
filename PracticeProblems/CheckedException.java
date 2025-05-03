import java.io.*;

public class CheckedException {
    public static void main(String[] args) {
        String file = "names.txt";
        try(FileReader fr = new FileReader(file)){
            int i;
            while((i = fr.read()) != -1){
                System.out.print((char) i);
            }
            System.out.println("\nExecuted perfectly!");
        } catch (IOException e) {
            System.out.println("File not found! "+e.getMessage());
        }
    }
}
