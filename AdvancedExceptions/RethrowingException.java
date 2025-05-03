public class RethrowingException {

    public static void performDivison(int num, int den) {
        try {
            int div = num / den;
            System.out.println("Divison: " + div);
        } catch (ArithmeticException e){
        throw new ArithmeticException("Invalid denominator"+e.getMessage());
        }
    }

    public static void calculate(int num, int den){
        performDivison(num, den);
    }

    public static void main(String[] args) {
        try{
            calculate(5,0);
        }catch(ArithmeticException e){
            System.out.println("Cant divide by zero: "+e.getMessage());
        }
    }
}
