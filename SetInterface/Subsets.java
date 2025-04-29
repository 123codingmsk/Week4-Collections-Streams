import java.util.Set;
import java.util.HashSet;

public class Subsets{
	
	public static boolean subsetPresent(Set<Integer> set1, Set<Integer> set2){
		if(set2.containsAll(set1)){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] a){
		Set<Integer> set1 = Set.of(2,3);
		Set<Integer> set2 = Set.of(1,2,3,4);
		
		boolean res = subsetPresent(set1,set2);
		System.out.println(res);
	}
}