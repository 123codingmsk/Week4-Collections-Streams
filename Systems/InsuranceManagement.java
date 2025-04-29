import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
//policy class
class Policy implements Comparable<Policy>{
	private final int policyID;
	private static int counter = 0;
	private String holderName;
	private LocalDate expiryDate;
	public String coverageType;
	private int premiumAmount;
	
	Policy(String holderName, int premiumAmount){
		this.policyID = ++counter;
		this.holderName = holderName;
		this.premiumAmount = premiumAmount;
	}
	
	public int getPolicyID(){
		return policyID;
	}
	
	public LocalDate getExpiryDate(){
        return expiryDate;
    }
	
	public String getCoverageType(){
        return coverageType;
    }
	
	public void setExpiryDate(String expiryDate){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.expiryDate = LocalDate.parse(expiryDate, formatter); 
	}
	
	public void setCoverageType(String coverageType){
		this.coverageType = coverageType; 
	}
	
	public void displayPolicy(){
		System.out.println("ID: "+policyID+"  Name: "+holderName);
		System.out.println("ExpiryDate: "+expiryDate+" Coverage: "+coverageType+" Amount: "+premiumAmount);
	}
	
	@Override
	public int compareTo(Policy other){
		return this.expiryDate.compareTo(other.expiryDate);
	}
}

class PolicyStorage{
	//store unique policies
	Set<Policy> hashset = new HashSet<>();
	Set<Policy> linkedhashset = new LinkedHashSet<>();
	Set<Policy> treeset = new TreeSet<>();
	
	public void addPolicy(Policy policy){
		hashset.add(policy);
		linkedhashset.add(policy);
		treeset.add(policy);
	}

	//retrieve policies
	public void displaypolicies(){
		System.out.println("\nAll unique policies: ");
		for(Policy p : hashset){
			p.displayPolicy();
		}
	}
	
	//expired after 30 days
	public void displayExpiringsoon(){
		LocalDate today = LocalDate.now();
		System.out.println("\nExpiring soon: ");
		for(Policy p : treeset){
			if(p.getExpiryDate() != null && p.getExpiryDate().isBefore(today.plusDays(30))){
				p.displayPolicy();
			}
		}
	}
	//display by coverages
	public void displayCoverages(String coverageType){
		System.out.println("coverageType: "+coverageType);
		for(Policy p : hashset){
			if(coverageType.equalsIgnoreCase(p.getCoverageType())){
				p.displayPolicy();
			}
		}
	}
}

public class InsuranceManagement{
	public static void main(String[] a){
		
		Policy p1 = new Policy("Manoj", 5000);
		p1.setExpiryDate("2025-05-20");
		p1.setCoverageType("Auto");
		
		Policy p2 = new Policy("Deekshith", 8000);
		p2.setExpiryDate("2025-05-15");
		p2.setCoverageType("Health");
		
		Policy p3 = new Policy("Raju", 7000);
		p3.setExpiryDate("2025-06-01");
		p3.setCoverageType("Home");
		
		Policy p4 = new Policy("Raghu", 2000);
		p4.setExpiryDate("2025-05-10");
		p4.setCoverageType("Auto");
		
		PolicyStorage storage = new PolicyStorage();
		storage.addPolicy(p1);
		storage.addPolicy(p2);
		storage.addPolicy(p3);
		storage.addPolicy(p4);
		
		storage.displaypolicies();
		storage.displayExpiringsoon();
		storage.displayCoverages("Auto");
	}
}