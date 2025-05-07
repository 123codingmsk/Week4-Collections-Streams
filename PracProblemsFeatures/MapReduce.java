import java.util.Arrays;
import java.util.List;

public class MapReduce {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        int ans = list.parallelStream().filter(num->num % 2 == 0)
                .map(y->y*y).reduce(0,(sum,i)->sum+i);
        System.out.println(ans);
    }
}
