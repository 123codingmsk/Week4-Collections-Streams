import java.util.Set;
import java.util.HashSet;
public class SymmetricDiff{

	public static Set<Integer> findSymmetric(Set<Integer> set1, Set<Integer> set2){
		Set<Integer> res = new HashSet<>(set1);
		for(int i : set2){
			if(!res.contains(i)){
				res.add(i);
			}else{
				res.remove(i);
			}
		}
		return res;
	}

	public static void main(String[] a){
		Set<Integer> set1 = Set.of(1,2,3);
		Set<Integer> set2 = Set.of(3,4,5);
		
		System.out.println(findSymmetric(set1, set2));
	}
}