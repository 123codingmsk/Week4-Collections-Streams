import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class GroupObjects{
	
	public static <K,V> void groupObjects(Map<K, V> dep){
		Map<V, List<K>> res = new HashMap<>();
		for(Map.Entry<K, V> entry : dep.entrySet()){
			K key = entry.getKey();
			V value = entry.getValue();
			
			if(!res.containsKey(value)){
				List<K> newList = new ArrayList<>();
				newList.add(key);
				res.put(value, newList);
			}else{
				res.get(value).add(key);
			}
		}
		System.out.println(res);
	}	
	
	public static void main(String[] a){
		Map<String, String> dep = new HashMap<>();
		dep.put("Alice", "HR");
		dep.put("Bob", "IT");
		dep.put("Carol", "HR");
		
		groupObjects(dep);
	}
}