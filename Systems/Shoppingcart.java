import java.util.*;

public class Shoppingcart{
	public static void main(String[] a){
		Map<String,Integer> map1 = new HashMap<>();
		map1.put("Milk", 10);
		map1.put("Lays", 20);
		map1.put("Eclairs", 1);
		map1.put("Rice", 100);
		System.out.println(map1+"\n");
		
		map1 = new LinkedHashMap<>();
		map1.put("Milk", 10);
		map1.put("Lays", 20);
		map1.put("Eclairs", 1);
		map1.put("Rice", 100);
		System.out.println(map1+"\n");
		
		map1 = new TreeMap<>();
		map1.put("Milk", 10);
		map1.put("Lays", 20);
		map1.put("Eclairs", 1);
		map1.put("Rice", 100);
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map1.entrySet());
        list.sort(Map.Entry.comparingByValue());
		for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
	}
}