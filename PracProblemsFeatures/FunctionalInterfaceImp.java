@FunctionalInterface
interface Sum{
    int getSum(int a, int b);
}

public class FunctionalInterfaceImp {
    public static void main(String[] args) {
        Sum s = (a,b)-> a+b;
        int ans = s.getSum(3,4);
        System.out.println(ans);
    }
}
