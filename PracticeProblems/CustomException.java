import java.util.Scanner;

class InvalidAgeException extends Exception{
    InvalidAgeException(String message){
        super(message);
    }
}

public class CustomException {

    public static void validate(int age) throws InvalidAgeException{
        if(age >= 18){
            System.out.println("Access granted");
        }else{
            throw new InvalidAgeException("Age must be 18 or above");
        }
    }

    public static void main(String[] args) {
        try(Scanner scn = new Scanner(System.in)){
            System.out.println("Enter your age: ");
            int age = scn.nextInt();
            validate(age);
        }catch(InvalidAgeException e){
            System.out.println("Custom exception: "+e.getMessage());
        }
    }
}
