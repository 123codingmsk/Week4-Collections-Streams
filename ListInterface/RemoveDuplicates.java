import java.util.List;
import java.util.LinkedList;

public class RemoveDuplicates{
	
	public static void removeDuplicates(List<Integer> list){
		for(int i=0; i<list.size()-1; i++){
			int temp = list.get(i);
			for(int j=i+1; j<list.size(); ){
				if(list.get(j)== temp){
					list.remove(j);
				}else{
					j++;
				}
			}
		}
	}
	
	public static void main(String[] a){
		List<Integer> list = new LinkedList<>();
		list.add(3);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(4);
		
		removeDuplicates(list);
		System.out.print(list);
	}
}