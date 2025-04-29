import java.util.*;
public class CircularBuffer {
    static Queue<Integer> buffer = new ArrayDeque<>();

    public static void offer(int n){
        if(buffer.size() == 3){
            buffer.poll();
        }
        buffer.offer(n);
    }

    public static void main(String[] args){
        offer(2); offer(3);
        offer(4); offer(5);
        offer(7);
        System.out.println(buffer);
    }
}