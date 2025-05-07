import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Claim{
    int claimId;
    static int counter = 0;
    String policyNum;
    double claimAmount;
    String claimDate;
    boolean status;

    Claim(String policyNum, double claimAmount, String claimDate, boolean status){
        this.claimId = ++counter;
        this.policyNum = policyNum;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }

    @Override
    public String toString(){
        return "claimId: "+claimId+" policyNum: "+policyNum+" claimAmount: "
                +claimAmount+" claimDate: "+claimDate+" status: "+status;
    }
}

public class ClaimAnalysis {

    public static void filterByAmount(List<Claim> claim){
        System.out.println("Filter By Amount: ");
        claim.stream().filter(c->c.status==true && c.claimAmount > 5000)
                .forEach(System.out::println);
        System.out.println();
    }

    public static void groupByClaims(List<Claim> claim){
        Map<String, List<Claim>> grouped = claim.stream().collect(Collectors.groupingBy(c->c.policyNum));
        grouped.forEach((polNum, policylist)->{
            System.out.printf("\n Policy->"+polNum+"\n");
            policylist.forEach(System.out::println);
        });
    }

    public static void getTotandAvg(List<Claim> claim){
        System.out.println("\nTotal Value: "+claim.stream().map(c->c.claimAmount)
                .reduce(0.0, Double::sum));
        System.out.println("\nAverage Value: "+claim.stream().mapToDouble(c->c.claimAmount)
                .average());
    }

    public static void top3byAmount(List<Claim> claim){
        System.out.println("Top 3 high paid claim Amounts: ");
        claim.stream().sorted((c1, c2)->Double.compare(c2.claimAmount, c1.claimAmount))
                .limit(3).forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Claim> list = Arrays.asList(
                new Claim("A1", 7000, "4thJuly", true),
                new Claim("B1", 3500, "6thJuly", false),
                new Claim("C1", 4500, "5thAug", true),
                new Claim("D1", 6700, "13thSep", false)
        );

        filterByAmount(list);
        groupByClaims(list);
        getTotandAvg(list);
        top3byAmount(list);
    }
}
