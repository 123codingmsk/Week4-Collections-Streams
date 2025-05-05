import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HexColorCode {
    public static void main(String[] args) {
        String regex = "#[0-9A-Fa-f]{6}";
        Pattern pattern = Pattern.compile(regex);
        System.out.print("Type HexCode: ");
        Scanner scn = new Scanner(System.in);
        String input = scn.next();
        Matcher matcher = pattern.matcher(input);
        if(matcher.matches()){
            System.out.println("Valid code: "+input);
        }else{
            System.out.println("Invalid code: "+input);
        }
    }
}
