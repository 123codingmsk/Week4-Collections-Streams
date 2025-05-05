import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extraction {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";
        String regex = "[a-zA-Z]+@[a-zA-Z]+\\.[a-z]{3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Searching matches...");
        while(matcher.find()){
            System.out.println("Matched: "+matcher.group());
        }
    }
}
