import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCreditCard {

    public static void validateCard(String ip){
        String regex = "4\\d{15}|5\\d{15}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);

        if(matcher.find()){
            System.out.println("Valid card number");
        }else{
            System.out.println("Invalid card number");
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the creditcard number: ");
        Scanner scn = new Scanner(System.in);
        String ip = scn.next();
        validateCard(ip);
    }
}
