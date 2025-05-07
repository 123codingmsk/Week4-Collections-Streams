import java.util.function.BiFunction;

public class BiFunctionInterfaceImp {
    public static void main(String[] args) {
        BiFunction<String, String, String> concat = (a,b)->a+" "+b;
        System.out.println(concat.apply("Manoj", "Kumar"));
    }
}
