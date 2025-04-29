import java.util.*;

public class Merge2maps{

	public static void mergemaps(Map<Character, 
		Integer> map1, Map<Character, Integer> map2){
		Map<Character, Integer> res = new HashMap<>(map1);
		
		for(Map.Entry<Character, Integer> entry : map2.entrySet()){
			int sum = res.getOrDefault(entry.getKey(), 0);
			res.put(entry.getKey(), sum + entry.getValue());
		}
		System.out.println(res);
	}

	public static void main(String[] a){
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();
		
		map1.put('A', 1);
		map1.put('B', 2);
		
		map2.put('B', 3);
		map2.put('C', 4);
		
		mergemaps(map1, map2);
		
	}
}