import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Policy implements Comparable<Policy>{
	public String name;
	public String policyType;
	public LocalDate expiryDate;
	public int amount;
	
	Policy(String name, String policyType, int amount){
		this.name = name;
		this.policyType = policyType;
		this.amount = amount;
	}
	
	public void setExpiryDate(String expiryDate){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.expiryDate = LocalDate.parse(expiryDate, formatter);
	}
	
	@Override
	public int compareTo(Policy other){
		return this.expiryDate.compareTo(other.expiryDate);
	}
	
	public void displayPolicy(){
		System.out.println("Name: "+name);
		System.out.println("Policy: "+policyType+" ExpiryDate: "+expiryDate+" Amount: "+amount+"\n");
	}
}

class PolicyStorage{
	int policyNum = 1;
	Map<Integer, Policy> hash = new HashMap<>();
	Map<Integer, Policy> linkedhash = new LinkedHashMap<>();
	Map<Integer, Policy> tree = new TreeMap<>();
	
	public void addPolicy(Policy policy){
		hash.put(policyNum, policy);
		linkedhash.put(policyNum, policy);
		tree.put(policyNum, policy);
		policyNum++;
	}
	
	//retreive policies by a policyNum
	public void getPolicyByNumber(int policyNumber){
		System.out.println("Policy Number: "+policyNumber);
		
		Policy policy = hash.get(policyNumber);
		if(policy != null){
			policy.displayPolicy();
		}else{
			System.out.println("Policy not found!\n");
		}
	}
	
	//expiring in next 30 days
	public void getPoliciesExpiring(){
		LocalDate today = LocalDate.now();
		boolean found = false;
		System.out.println("Soon Expiring Policies: ");
		for(Map.Entry<Integer, Policy> entry : tree.entrySet()){
			Policy p = tree.get(entry.getKey());
			if(p.expiryDate != null && p.expiryDate.isBefore(today.plusDays(30))){
				found = true;
				p.displayPolicy();
			}
		}
		if(!found){
			System.out.println("No policies are expiring in 30days");
		}
	}
	
	//policies of specific holder
	public void getPoliciesofHolder(String holderName){
		System.out.println("Policies linked to : "+holderName);
		boolean found = false;
		for(Map.Entry<Integer, Policy> entry : tree.entrySet()){
			Policy p = tree.get(entry.getKey());
			if(p.name.equals(holderName)){
				p.displayPolicy();
				found = true;
			}
		}
		if(!found){
			System.out.println("No policies are found linked to "+holderName);
		}
	}
	
	//remove policies that are expired
	public void removeExpiredPolicies(){
		System.out.println("Policies that are expired and removed: ");
		LocalDate today = LocalDate.now();
		boolean found = false;
    
		Iterator<Map.Entry<Integer, Policy>> iterator = tree.entrySet().iterator();
		
		while(iterator.hasNext()){
			Map.Entry<Integer, Policy> entry = iterator.next();
			Policy p = entry.getValue();
			
			if(p.expiryDate.isBefore(today)){
				p.displayPolicy();
				iterator.remove(); 
				found = true;
			}
		}
		if(!found){
			System.out.println("No policies that are expired");
		}
	}
	
}

public class InsuranceManagement2{
	public static void main(String[] a){
		Policy p1 = new Policy("Manoj", "Health", 20000);
		p1.setExpiryDate("2025-09-28");
		
		Policy p2 = new Policy("Deekshith", "Home", 20000);
		p2.setExpiryDate("2025-07-28");
		
		Policy p3 = new Policy("Manoj", "Auto", 20000);
		p3.setExpiryDate("2025-03-28");
		
		PolicyStorage storage = new PolicyStorage();
		storage.addPolicy(p1);
		storage.addPolicy(p2);
		storage.addPolicy(p3);
		
		storage.getPolicyByNumber(2);
		
		storage.getPoliciesExpiring();
		
		storage.getPoliciesofHolder("Manoj");
		
		storage.removeExpiredPolicies();
	}
}