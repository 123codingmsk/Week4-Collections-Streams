import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ElementsFrequency{
	public static void main(String[] a){
		List<String> list = Arrays.asList("apple","banana","apple","orange");
		HashMap<String, Integer> mpp = new LinkedHashMap<>();
		
		for(String i : list){
			int value = mpp.getOrDefault(i, 0);
			mpp.put(i, value+1);
		}
		
		System.out.println(mpp);
	}
}