public class ExceptionPropMethods {

    public static void method1(){
        int num1 = 20;
        int num2 = 0;
        System.out.println(num1/num2);
    }

    public static void method2(){
        System.out.println("started..");
        method1();
    }

    public static void main(String[] args) {
        try {
            method2();
        }catch (ArithmeticException e){
            System.out.println("invalid input in num2: "+e.getMessage());
        }
    }
}
