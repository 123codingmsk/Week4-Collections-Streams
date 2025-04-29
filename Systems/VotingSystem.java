import java.util.*;
public class VotingSystem{
	
	public static <K, V> Map<K, V> storing(Map<K, V> map) {
        map.put((K) "Deekshith", (V) (Integer) 14000);
        map.put((K) "Manoj", (V) (Integer) 10000);
        map.put((K) "Raju", (V) (Integer) 20000);
        map.put((K) "Rajesh", (V) (Integer) 15000);
        return map;
    }
	
	public static void main(String[] a){
		Map<String, Integer> hashed = storing(new HashMap<>());
		System.out.println(hashed+"\n");
		
		Map<String, Integer> order = storing(new LinkedHashMap<>());
		System.out.println(order+"\n");
		
		Map<String, Integer> sorted = storing(new TreeMap<>());
		List<Map.Entry<String, Integer>> list = new ArrayList<>(sorted.entrySet());
		list.sort(Map.Entry.comparingByValue());
		for(Map.Entry<String, Integer> entry : list){
			System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
	}
}