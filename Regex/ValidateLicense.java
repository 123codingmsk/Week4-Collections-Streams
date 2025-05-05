import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateLicense {
    public static void main(String[] args) {
        String regex = "[A-Z]{2}[0-9]{4}";
        Pattern pattern = Pattern.compile(regex);
        System.out.println("Enter your license number: ");
        Scanner scn = new Scanner(System.in);
        String input = scn.next();
        Matcher matcher = pattern.matcher(input);

        if(matcher.matches()){
            System.out.println("Valid plate number: "+input);
        }else{
            System.out.println("Invalid plate number: "+input);
        }
    }
}
