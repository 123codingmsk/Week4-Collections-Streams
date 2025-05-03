import java.util.Scanner;

class InsufficientBalanceException extends Exception{
    InsufficientBalanceException(String message){
        super(message);
    }
}

public class BankTransaction {

    public static void withdraw(double amount) throws InsufficientBalanceException{
        double balance = 100.0;
        if(amount > 0){
            if(amount <= balance){
                System.out.println("Withdraw successful, new balance: "+(balance - amount));
            }else{
                throw new InsufficientBalanceException("Insufficient balance");
            }
        }else{
            throw new IllegalArgumentException("Invalid amount");
        }
    }

    public static void main(String[] args) {
        try(Scanner scn = new Scanner(System.in)){
            System.out.println("Enter your withdraw amount: ");
            double withdrawAmount = scn.nextDouble();
            withdraw(withdrawAmount);
        }catch (InsufficientBalanceException e){
            System.out.println("Balance issue! "+e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("Give valid amount: "+e.getMessage());
        }

    }
}
