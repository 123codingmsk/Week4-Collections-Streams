import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalHandling {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Optional<Integer> value = list.stream().max((a, b)->a-b);
        System.out.println(value.orElse(0));
    }
}
