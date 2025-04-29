import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class ReverseQ{

	public static void reverseQ(Queue<Integer> q){
		if(q.isEmpty()){
			return;
		}
		/*while(len > 0){
			int temp = q.remove();
			q.add(temp);
			len--;
		}*/
		int temp = q.remove();
		reverseQ(q);//doing recursion 
		
		q.add(temp);
	}

	public static void main(String[] a){
		Queue<Integer> q = new LinkedList<>(Arrays.asList(10, 20, 30));
		reverseQ(q);
		System.out.println(q);
	}
}