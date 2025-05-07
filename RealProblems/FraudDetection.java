import java.util.*;
import java.util.stream.Collectors;
class Transaction {
    String transactionId;
    String policyNumber;
    double amount;
    String transactionDate;
    boolean isFraudulent;
    public Transaction(String transactionId, String policyNumber, double amount, String transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }
}
public class FraudDetection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Transaction> transactions = new ArrayList<>();
        System.out.print("Enter number of transactions: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter details for transaction " + i + ":");
            System.out.print("Transaction ID: ");
            String transactionId = sc.nextLine();
            System.out.print("Policy Number: ");
            String policyNumber = sc.nextLine();
            System.out.print("Amount: ");
            double amount = Double.parseDouble(sc.nextLine());
            System.out.print("Transaction Date: ");
            String transactionDate = sc.nextLine();
            System.out.print("Is Fraudulent (true/false): ");
            boolean isFraudulent = Boolean.parseBoolean(sc.nextLine());
            transactions.add(new Transaction(transactionId, policyNumber, amount, transactionDate, isFraudulent));
        }
        List<Transaction> filtered = transactions.stream()
                .filter(t -> t.isFraudulent && t.amount > 10000)
                .collect(Collectors.toList());
        Map<String, List<Transaction>> groupedByPolicy = filtered.stream()
                .collect(Collectors.groupingBy(t -> t.policyNumber));
        System.out.println("\nAlerts for Fraudulent Policies:");
        for (Map.Entry<String, List<Transaction>> entry : groupedByPolicy.entrySet()) {
            String policy = entry.getKey();
            List<Transaction> policyTxns = entry.getValue();
            int count = policyTxns.size();
            double totalAmount = policyTxns.stream().mapToDouble(t -> t.amount).sum();
            if (count > 5 || totalAmount > 50000) {
                System.out.println("ALERT: Policy " + policy +
                        " | Fraudulent Transactions: " + count +
                        " | Total Fraud Amount: $" + totalAmount);
            }
        }
    }
}
