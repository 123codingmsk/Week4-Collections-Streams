import java.util.Queue;
import java.util.LinkedList;

public class QueueToStack{
	
	public static void push(Queue<Integer> q1, int num) {
        q1.add(num);
        int size = q1.size();
        for (int i=0; i<size-1; i++) {
            q1.add(q1.remove());
        }
    }

    public static int pop(Queue<Integer> q1) {
        return q1.remove();
    }
	
	public static int top(Queue<Integer> q1){
		return q1.peek();
	}
	
	public static void main(String[] a){
		Queue<Integer> q1 = new LinkedList<>();
		push(q1, 1);
		push(q1, 2);
		push(q1, 3);
		
		System.out.println(q1);
		System.out.println(pop(q1));
		System.out.println(q1);
		System.out.println(top(q1));
	}
}