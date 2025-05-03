public class ExceptionPropagation {

    public static void calculateInterest(double amount, double rate, int years) throws IllegalArgumentException{
        if(amount >0 && rate > 0){
            double interest = (amount * rate * years) / 100;
            System.out.println(interest);
        }
        else{
            throw new IllegalArgumentException("Invalid Input: Amount and rate must be positive");
        }
    }

    public static void main(String[] args) {
        try {
            double amount = 1000.0;
            double rate = -2.0;
            int years = 4;
            calculateInterest(amount, rate, years);
        }catch(IllegalArgumentException e){
            System.out.println("Invalid Arguments: "+e.getMessage());
        }
    }
}
