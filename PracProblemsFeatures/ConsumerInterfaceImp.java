import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterfaceImp {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("manoj","sai","kumar");
        Consumer<String> upcase = word -> System.out.println(word.toUpperCase());
        upcase.accept(words.toString());
    }
}
