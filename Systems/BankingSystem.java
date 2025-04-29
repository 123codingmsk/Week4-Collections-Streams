import java.util.*;

public class BankingSystem{

	public static  Map<String, Integer> accounts(Map<String, Integer> map){
		map.put("12345679", 9785);
		map.put("234567", 3456);
		map.put("3453453", 11344);
		
		return map;
	}
		
	public static void main(String[] a){
		Map<String, Integer> hash = accounts(new HashMap<>());
		System.out.println(hash);
		
		Map<String, Integer> tree = accounts(new TreeMap<>());
		List<Map.Entry<String, Integer>> list = new ArrayList<>(tree.entrySet());
		list.sort(Map.Entry.comparingByValue());
		
		for(Map.Entry <String, Integer> entry : list){
			System.out.println(entry.getKey()+"-->"+entry.getValue());
		}
	}
}