import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class UserAlreadyExistsException extends Exception{
    UserAlreadyExistsException(String message){
        super(message);
    }
}

class UserNotFoundException extends Exception{
    UserNotFoundException(String message){
        super(message);
    }
}

public class UserService {

    static List<String> users = new ArrayList<>(Arrays.asList("manoj", "deekshith"));

    public static void registerUser(String username) throws UserAlreadyExistsException{
        if(users.contains(username)){
            throw new UserAlreadyExistsException("user already present in db");
        }else {
            users.add(username);
            System.out.println("User registered Successfully!");
        }
    }

    public static boolean checkUserExistence(String username) throws UserNotFoundException{
        if(!users.contains(username)){
            throw new UserNotFoundException("user is not present in db");
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        try(Scanner scn = new Scanner(System.in)){
            System.out.println("Enter username: ");
            String name = scn.nextLine();
            try{
                registerUser(name);
            }catch (UserAlreadyExistsException e){
                System.out.println("User already exists! "+e.getMessage());
            }
            try{
                if(checkUserExistence(name)){
                    System.out.println("User found in db");
                }
            } catch (UserNotFoundException e) {
                System.out.println("Error: "+e.getMessage());
            }
        }
    }
}
