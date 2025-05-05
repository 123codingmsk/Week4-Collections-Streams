import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractCaptilized {
    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        String regex = "[A-Z][A-Za-z]{1,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matches = pattern.matcher(text);

        while(matches.find()){
            System.out.println(matches.group());
        }
    }
}
