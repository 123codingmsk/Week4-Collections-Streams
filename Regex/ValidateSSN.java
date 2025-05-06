import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateSSN {
    public static void main(String[] args) {
        String text ="My SSN is 123456789.";
        String regex = "\\d{3}-\\d{2}-\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()){
            System.out.println("Valid: "+text);
        }else{
            System.out.println("Invalid: "+text);
        }
    }
}
