import java.util.Scanner;

public class MultipleCatch {
    public static void main(String[] args) {
        //int[] arr = {1,2,3};
        int[] arr = null;
        try(Scanner scn = new Scanner(System.in)){
            System.out.print("Give index, 0 based indexing: ");
            int index = scn.nextInt();

            System.out.println("Value at index " +index+" : "+arr[index]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Index: "+e.getMessage());
        }catch (NullPointerException e){
            System.out.println("Array is not initialised: "+e.getMessage());
        }
    }
}
