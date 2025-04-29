import java.util.HashSet;
public class EqualSetsOrNot{
	
	public static void main(String[] a){
		
		HashSet<Integer> set1 = new HashSet<>();
		set1.add(1);set1.add(2);set1.add(3);
		
		HashSet<Integer> set2 = new HashSet<>();
		set2.add(3);set2.add(4);set2.add(1);
		
		for(int i : set1){
			if(set2.contains(i)){
				continue;
			}else{
				System.out.print("Not equal");
				return;
			}
		}
		System.out.println("Equal");
	}
}