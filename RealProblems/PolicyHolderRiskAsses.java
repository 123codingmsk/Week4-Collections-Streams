import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class PolicyHolder{
    int holderId;
    static int counter = 1;
    String name;
    int age;
    String policyType;
    int premiumAmount;

    PolicyHolder(String name, int age, String policyType, int premiumAmount){
        this.name  = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
        this.holderId = counter++;
    }

    @Override
    public String toString(){
        return "ID: "+holderId+" Name: "+name+" age: "+age+" Type: "
                +policyType+" Amount: "+premiumAmount;
    }
}

class RiskAssessment{
    int holderId;
    String name;
    double riskScore;

    public RiskAssessment(int holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }
    @Override
    public String toString(){
        return "ID: "+holderId+" Name: "+name+" RiskScore: "+riskScore;
    }
}
public class PolicyHolderRiskAsses {

    public static void filterByType(List<PolicyHolder> pol){
        System.out.println("Filter By Type and Age: ");
        pol.stream().filter(p->p.policyType=="Health" && p.age > 60)
                .forEach(System.out::println);
        System.out.println();
    }

    public static List<RiskAssessment> transform(List<PolicyHolder> ra){
        return ra.stream().map(r->new RiskAssessment(r.holderId, r.name, r.premiumAmount/r.age)).toList();
    }

    public static void sortByRiskScore(List<RiskAssessment> ra){
        System.out.println("Sort by RiskScore: ");
        ra.stream().sorted((s1, s2)->Double.compare(s2.riskScore, s1.riskScore))
                .forEach(System.out::println);
        System.out.println();
    }

    public static void categorizeRisk(List<RiskAssessment> riskList) {
        System.out.println("Categorized Risk Groups:");

        Map<String, List<RiskAssessment>> categorized = riskList.stream()
                .collect(Collectors.groupingBy(r -> r.riskScore > 0.5 ? "High Risk" : "Low Risk"));

        categorized.forEach((category, assessments) -> {
            System.out.println("\n" + category + ":");
            assessments.forEach(System.out::println);
        });
    }

    public static void main(String[] args) {
        List<PolicyHolder> list = Arrays.asList(
                new PolicyHolder("Manoj", 21, "Insurance", 20000),
                new PolicyHolder("Deekshith", 65, "Health", 30000)
        );

        filterByType(list);
        List<RiskAssessment> risk = transform(list);
        risk.forEach(System.out::println);
        sortByRiskScore(risk);
        categorizeRisk(risk);
    }
}
