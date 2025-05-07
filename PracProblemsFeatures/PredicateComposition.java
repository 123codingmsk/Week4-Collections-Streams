import java.io.StringBufferInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateComposition {
    public static void main(String[] args) {
        //Predicate Composition---> isEqual, and, or, negate, test
        String substring = "a";
        List<String> words = Arrays.asList("manojsai","deekshith","raju");

        //List<String> filtered = words.stream()
        //   .filter(word -> word.length() > 5 && word.contains(substring))
        //   .toList());

        Predicate<String> morethan5 = word->word.length() > 5;
        Predicate<String> containSubstring = word->word.contains(substring);
        Predicate<String> combined = morethan5.and(containSubstring);

        List<String> filtered = words.stream().filter(combined).toList();
        System.out.printf(filtered.toString());
    }
}
