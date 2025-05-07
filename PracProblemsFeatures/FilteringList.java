import java.util.Arrays;
import java.util.List;

public class FilteringList {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Adi","Arundathi","Manoj","Deekshith");
        List<String> filtered = names.stream().filter(name->name.startsWith("A")).toList();
        System.out.println(filtered);
    }
}
