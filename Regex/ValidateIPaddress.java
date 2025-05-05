import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateIPaddress {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter IP Address: ");
        String ip = scn.next();
        String regex = "[0-2][0-5][0-5]\\.[0-2][0-5][0-5]\\.[0-2][0-5][0-5]\\.[0-2][0-5][0-5]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);

        if(matcher.find()){
            System.out.println("Valid IP Address: "+ip);
        }else{
            System.out.println("Invalid IP Address: "+ip);
        }
    }
}
