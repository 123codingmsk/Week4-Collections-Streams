import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class ReverseList{
	
	public static <T> void reverseList(List<T> list){
		int left = 0;
		int right = list.size()-1;
		while(left < right){
			T temp = list.get(left);
			list.set(left, list.get(right));
			list.set(right, temp);
			left++;
			right--;
		}
	}
	
	public static void main(String[] a){
		List<Integer> list1 = new ArrayList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);//we can use Arrays.asList(1,2,3,4,5)
		
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		
		reverseList(list1);
		reverseList(list2);
		System.out.println("Using ArrayList: "+list1);
		System.out.println("Using Linkedlist: "+list2);
	}
}