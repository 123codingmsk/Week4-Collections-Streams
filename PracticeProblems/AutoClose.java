import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AutoClose {
    public static void main(String[] args) {
        String file = "names.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line = br.readLine();
            if(line != null){
                System.out.println(line);
            }
        }catch(IOException e){
            System.out.println("Error reading file: "+e.getMessage());
        }
    }
}
