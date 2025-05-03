import java.util.Scanner;

public class NestedTry {
    public static void main(String[] args) {
        try(Scanner scn = new Scanner(System.in)) {
            int[] arr = {1, 2, 3};
            System.out.println("Enter the index: ");
            int index = scn.nextInt();
            int value;
            try {
                value = arr[index];
                System.out.println("Value at index " + index + " : " + value);
                System.out.println("Enter the Divisor: ");
                int divisor = scn.nextInt();
                try {
                    int div = value / divisor;
                    System.out.println("Division: " + div);
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero: " + e.getMessage());
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid Array index: " + e.getMessage());
            }
        }
    }
}
