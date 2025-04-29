import java.util.*;
public class HighestVal{
	public static void main(String[] a){
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 10);
		map.put("B", 20);
		map.put("C", 15);
		
		int maxVal = Integer.MIN_VALUE;
		String maxValKey = null;
		 for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxVal) {
                maxVal = entry.getValue();
                maxValKey = entry.getKey();
            }
        }
		System.out.println(maxValKey);
	}
}