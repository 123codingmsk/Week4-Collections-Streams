import java.util.function.Function;

public class FunctionInterfaceImp {
    public static void main(String[] args) {
        Function<Double, Double> area = radius -> 3.14*radius*radius;
        System.out.println(area.apply(4.0));
    }
}
