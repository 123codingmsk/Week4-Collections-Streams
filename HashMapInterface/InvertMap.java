import java.util.*;
public class InvertMap{
	
	public static <K, V> Map<V, List<K>> invertMap(Map<K, V> original) {
        Map<V, List<K>> inverted = new HashMap<>();

        for (Map.Entry<K, V> entry : original.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();

            if (!inverted.containsKey(value)) {
                List<K> newList = new ArrayList<>();
                newList.add(key);
                inverted.put(value, newList);
            } else {
                inverted.get(value).add(key);
            }
        }
        return inverted;
    }
	
	public static void main(String[] a){
		char[] letters = {'A','B','B','C'};
		Map<Character, Integer> map1 = new HashMap<>();
		
		for(char ele : letters){
			int freq = map1.getOrDefault(ele, 0);
			map1.put(ele, freq+1);
		}
		
		Map<Integer, List<Character>> output = invertMap(map1);
		System.out.println(output);
	}
}