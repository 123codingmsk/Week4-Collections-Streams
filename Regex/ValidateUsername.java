import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUsername {
    public static void main(String[] args) {

        String regex = "^[a-zA-Z][a-zA-Z0-9_]{5,15}$";
        Pattern pattern  = Pattern.compile(regex);
        System.out.println("Enter your username: \n " +
                "starts with letter, can contain(a-z, A-Z, 0-9, _)");
        Scanner scn = new Scanner(System.in);
        String input = scn.next();
        Matcher matcher = pattern.matcher(input);

        if(matcher.matches()){
            System.out.println("Valid username: "+input);
        }else{
            System.out.println("Invalid Username: "+input);
        }
    }
}
