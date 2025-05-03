import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileProcessor {

    public static void processFiles(List<String> filepaths){
        for(String file : filepaths){
            try(BufferedReader br = new BufferedReader(new FileReader(file))){
                String line;
                while((line = br.readLine()) != null){
                    continue;
                }
            }catch (IOException e){
                System.out.println("File not found: "+e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        List<String> filepaths = Arrays.asList("names.txt", "info.txt", "list.txt");
        processFiles(filepaths);
    }
}
