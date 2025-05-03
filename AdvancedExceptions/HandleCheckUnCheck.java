import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class HandleCheckUnCheck {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        String file = "manoj.txt";
        try{
            System.out.println(list.get(5));
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while((line = br.readLine()) != null){
                continue;
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
