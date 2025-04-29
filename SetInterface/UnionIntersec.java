import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

public class UnionIntersec{
	public static Set<Integer> findUnion(Set<Integer> set1, Set<Integer> set2){
		Set<Integer> union = new HashSet<>();
		for(int i : set1){
			union.add(i);
		}
		for(int j : set2){
			union.add(j);
		}
		return union;
	}
	public static Set<Integer> findIntersection(Set<Integer> set1, Set<Integer> set2){
		HashMap<Integer, Integer> mpp = new HashMap<>();
		Set<Integer> intersection = new HashSet<>();
		for(int i : set1){
			int freq = mpp.getOrDefault(i, 0);
			mpp.put(i, freq + 1);
		}
		for(int i : set2){
			int freq = mpp.getOrDefault(i, 0);
			mpp.put(i, freq + 1);
		}
		for(int k : mpp.keySet()){
			if(mpp.get(k) > 1){
				intersection.add(k);
			}
		}
		return intersection;
	}
		
	public static void main(String[] a){
		Set<Integer> set1 = Set.of(1,2,3);
		Set<Integer> set2 = Set.of(3,4,5);
		
		System.out.println("Union: "+findUnion(set1, set2));
		System.out.println("Intersection: "+findIntersection(set1, set2));
	}
}