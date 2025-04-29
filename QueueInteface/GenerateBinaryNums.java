import java.util.*;

public class GenerateBinaryNums{

	public static List<String> generateBinaryNumbers(int n) {
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();

        q.add("1");

        for (int i = 0; i < n; i++) {
            String current = q.poll(); 
            res.add(current);          
			
            q.add(current + "0");
            q.add(current + "1");
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        List<String> binaries = generateBinaryNumbers(n);
        System.out.println("First " +n+" binary numbers: " + binaries);
    }
}