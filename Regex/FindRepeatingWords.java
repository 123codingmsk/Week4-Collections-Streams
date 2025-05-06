import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindRepeatingWords {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        String regex = "(\\w+)\\s+\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        HashSet<String> repeatedWords = new HashSet<>();

        while(matcher.find()){
            repeatedWords.add(matcher.group(1));
        }

        for (String word : repeatedWords) {
            System.out.println(word);
        }
    }
}
