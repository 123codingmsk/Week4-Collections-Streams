import java.util.LinkedList;

public class NthElement{
	public static void main(String[] a){
		LinkedList<Character> list = new LinkedList<>();
		list.add('A');list.add('B');
		list.add('C');list.add('D');list.add('E');
		
		char ans = (char)(list.getLast()-1);
		System.out.print(ans);
	}
}