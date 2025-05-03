import java.util.Scanner;

public class FinallyBlock {
    public static void main(String[] args) {
        try(Scanner scn = new Scanner(System.in)){
            System.out.println("enter num1: ");
            int num1 = scn.nextInt();
            System.out.println("Enter num2: ");
            int num2 = scn.nextInt();

            int div = num1 / num2;
            System.out.println(div);
        }catch (ArithmeticException e){
            System.out.println("Dont give 0 as denominator: "+e.getMessage());
        }finally {
            System.out.println("Operation Completed");
        }
    }
}
