import java.util.Arrays;
import java.util.List;
import java.util.Map;

class Sale{
    int productId;
    int quantity;
    double price;
    static int counter = 1;

    Sale(int quantity, double price){
        this.productId = counter++;
        this.quantity  =quantity;
        this.price = price;
    }

    @Override
    public String toString(){
        return "id: "+productId+" quantity: "+quantity+" price: "+price;
    }
}

class ProductSales{
    int productId;
    double totalRevenue;

    ProductSales(int productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Revenue: $" + totalRevenue;
    }
}

public class ProductSalesAnalysis {

    public static void filteredByquantity(List<Sale> sale){
        System.out.println("Quantity sold more than 10");
        sale.stream().filter(s->s.quantity > 10).forEach(System.out::println);
        System.out.println();
    }

    public static List<ProductSales> transformSales(List<Sale> sales) {
        return sales.stream()
                .map(sale -> new ProductSales(sale.productId, sale.quantity * sale.price))
                .toList();
    }

    public static void sortByRevenue(List<ProductSales> ps){
        ps.stream().sorted((s1, s2)->Double.compare(s1.totalRevenue, s2.totalRevenue))
                .forEach(System.out::println);
    }

    public static void top5(List<ProductSales> ps) {
        System.out.println("Top 5 Products by Revenue:");
        ps.stream()
                .sorted((s1, s2)-> Double.compare(s2.totalRevenue, s1.totalRevenue)) // descending
                .limit(5)
                .forEach(System.out::println);
    }


    public static void main(String[] args) {
        List<Sale> list = Arrays.asList(
                new Sale(12, 10.0),
                new Sale(5, 20),
                new Sale(20, 3)
        );

        filteredByquantity(list);
        List<ProductSales> res = transformSales(list);
        res.forEach(System.out::println);
        sortByRevenue(res);
        top5(res);

    }
}
