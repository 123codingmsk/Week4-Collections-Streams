interface Sqaure{
    void squareNum(int num);

    default void print(){
        System.out.println("Sqaure of a number: ");
    }
}

public class CustomFunctionalInterface {
    public static void main(String[] args) {
        Sqaure s = num -> System.out.println(num * num);
        s.print();
        s.squareNum(4);
    }
}
