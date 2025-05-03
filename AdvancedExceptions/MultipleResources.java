import java.io.*;
import java.util.*;

public class MultipleResources {
    public static void main(String[] args) {
        String outputfile = "output.txt";
        List<String> files = Arrays.asList("names.txt", "info.txt");
        for(String file : files){
            try(BufferedReader br = new BufferedReader(new FileReader(file));
                BufferedWriter bw = new BufferedWriter(new FileWriter(outputfile, true))
            ){
                String line;
                while((line = br.readLine()) != null){
                    bw.write(line);
                    bw.newLine();
                }
                System.out.println(file+" copied into output file");
            } catch (IOException e) {
                System.out.println("File not found "+e.getMessage());
            }
        }
    }
}
