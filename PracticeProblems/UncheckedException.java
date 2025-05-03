import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedException {
    public static void main(String[] args) {
        try(Scanner scn = new Scanner(System.in)){
            System.out.print("Enter num1");
            int num1 = scn.nextInt();
            System.out.print("Enter num2");
            int num2 = scn.nextInt();

            int div = num1 / num2;
            System.out.println(div);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error: "+e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Mismatched value: "+e.getMessage());
        }
    }
}
