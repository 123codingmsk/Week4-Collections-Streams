import java.util.Queue;
import java.util.PriorityQueue;

class Data implements Comparable<Data>{
	private String name;
	private int severity;
	
	Data(String name, int severity){
		this.name = name;
		this.severity = severity;
	}
	
	//i dont know these, chatgpt 
	@Override
	public int compareTo(Data other){
		return Integer.compare(other.severity, this.severity);
	}
	@Override
    public String toString() {
        return name + "(" + severity + ")";
    }
}

public class HospitalSystem{
	public static void main(String[] a){
		Data p1 = new Data("John", 3); 
		Data p2 = new Data("Alice", 5);
		Data p3 = new Data("Bob", 2);
		
		Queue<Data> q = new PriorityQueue<>();
		q.add(p1);
		q.add(p2);
		q.add(p3);
		
		while(!q.isEmpty()){
			System.out.println(q.poll());
		}
	}
}