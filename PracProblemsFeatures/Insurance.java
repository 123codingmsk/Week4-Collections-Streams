import java.util.*;

class Persons{
    String policyNum;
    String holderName;
    double premiumAmount;

    Persons(String policyNum, String name, double amount){
        this.policyNum = policyNum;
        this.holderName = name;
        this.premiumAmount = amount;
    }

    public String toString(){
       return "PolicyNumber: "+policyNum + ", " +
               "Name: "+holderName + ", " +
               "PremiumAmount: "+premiumAmount;
    }
}

public class Insurance {

    public static void filterPolicies(List<Persons> p){
        System.out.println("Filtered by Policies: ");
        p.stream().filter(person -> person.premiumAmount > 1200)
                .toList().forEach(System.out::println);
        System.out.println();
    }

    public static void sortByname(List<Persons> p){
        System.out.println("Sorted by Names: ");
        p.stream().sorted((p1, p2)->p1.holderName.compareTo(p2.holderName))
                .toList().forEach(System.out::println);
        System.out.println();
    }

    public static void getTotalAmount(List<Persons> p){
        double ans = p.stream().map(person-> person.premiumAmount)
                .reduce(0.0, (sum, i)->sum + i);
        System.out.println("Total Amount: "+ans+"\n");
    }

    public static void printPolicyDetails(List<Persons> p){
        System.out.println("Policy Details: ");
        p.stream().forEach(System.out::println);
        System.out.println();
    }

    public static void filterpolicyByrange(List<Persons> p){
        System.out.println("Amount range btw 1000 && 2000");
        p.stream()
                .filter(person->(person.premiumAmount>1000) && (person.premiumAmount <2000))
                .toList().forEach(System.out::println);
        System.out.println();
    }

    public static void policywithlargeAmount(List<Persons> p){
        System.out.println("Policy with Highest Amount: ");
        double maxAmount = p.stream().mapToDouble(person->person.premiumAmount).max().orElse(0.0);
        System.out.print(maxAmount+"\n");
    }

    public static void groupPolicyByName(List<Persons> p){
        System.out.println("Group by Holdername Initial Letter: ");
        p.stream().map(p1->p1.holderName).filter(p1->p1.startsWith("M")).toList()
                .forEach(System.out::println);
        System.out.println();
    }

    public static void getAverageAmount(List<Persons> p){
        double ans = p.stream().mapToDouble(p1->p1.premiumAmount)
                .average().orElse(500.0);
        System.out.println("Average Premium Amount: "+ans+"\n");
    }

    public static void sortByAmount(List<Persons> p){
        System.out.println("Sorted by Amount: ");
        p.stream()
                .sorted((p1, p2)->Double.compare(p1.premiumAmount, p2.premiumAmount))
                .forEach(System.out::println);
        System.out.println();
    }

    public static void policyexceededAmount(List<Persons> p){
        System.out.println("Policies exceeded 2000: ");
        p.stream().filter(p1->p1.premiumAmount > 2000).forEach(System.out::println);
        System.out.println();
    }

    public static void countPoliciesinRange(List<Persons> p){
        System.out.println("Count of Polcies by range....");
        System.out.println("0-1000: "+p.stream().filter(p1->p1.premiumAmount > 0 && p1.premiumAmount <= 1000).count());
        System.out.println("1001-2000: "+p.stream().filter(p1->p1.premiumAmount >= 1001 && p1.premiumAmount <= 2000).count());
        System.out.println(">2000: "+p.stream().filter(p1-> p1.premiumAmount > 2000).count());
    }

    public static void extractUniqueNames(List<Persons> p){
        System.out.println("Unique names in the Policies: ");
        p.stream().map(p1->p1.holderName).distinct().forEach(System.out::println);
        System.out.println();
    }

    public static void findSubstringHoldername(List<Persons> p){
        System.out.println("Substring contain policies: ");
        String susbstring = "a";
        p.stream().map(p1->p1.holderName)
                .filter(p1->p1.contains(susbstring)).forEach(System.out::println);
        System.out.println();
    }

    public static void mapNumstoAmounts(List<Persons> p){
        Map<String, Double> map = new HashMap<>();
        p.stream().forEach(p1->map.put(p1.policyNum, p1.premiumAmount));
        System.out.println("Everyone mapped to their amounts");
        map.forEach((num, amount)-> System.out.println(num+ ": "+amount));
        System.out.println();
    }

    public static void main(String[] args) {
        List<Persons> p = Arrays.asList(
                new Persons("A1", "Manoj", 1300.0),
                new Persons("B1", "Deekshith", 2000.0),
                new Persons("C1", "Raju", 900.0),
                new Persons("D1", "Kshitij", 2100.0)
        );

        filterPolicies(p);
        sortByname(p);
        getTotalAmount(p);
        printPolicyDetails(p);
        filterpolicyByrange(p);
        policywithlargeAmount(p);
        groupPolicyByName(p);
        getAverageAmount(p);
        sortByAmount(p);
        policyexceededAmount(p);
        countPoliciesinRange(p);
        extractUniqueNames(p);
        findSubstringHoldername(p);
        mapNumstoAmounts(p);
    }
}
