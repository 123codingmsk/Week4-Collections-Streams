import java.util.List;
import java.util.ArrayList;

abstract class JobRole{
	private String jobType;
	
	JobRole(String jobType){
		this.jobType = jobType;
	}
	
	public String getJobType(){
		return jobType;
	}
}

class SoftwareEngineer extends JobRole{
	SoftwareEngineer(String jobType){
		super(jobType);
	}
}

class DataScientist extends JobRole{
	DataScientist(String jobType){
		super(jobType);
	}
}

class ProductManager extends JobRole{
	ProductManager(String jobType){
		super(jobType);
	}
}

class Resume<T extends JobRole>{
	private String name;
	private String skill;
	private T jobrole;
	
	Resume(String name, String skill, T jobrole){
		this.name = name;
		this.skill = skill;
		this.jobrole = jobrole;
	}
	
	public String getName(){
		return name;
	}
	
	public String getSkill(){
		return skill;
	}
	
	public void displayResume(){
		System.out.println("Name: "+name);
		System.out.println("Skill: "+skill);
		System.out.println("Role: "+jobrole.getJobType());
	}
}

class HandleMultiplejobs{
	public static void screening(List<? extends Resume<? extends JobRole>> applicants){
		for(Resume<? extends JobRole> p : applicants){
			p.displayResume();
		}
	}
}

public class AIresumeScreening{
	public static void main(String[] a){
		SoftwareEngineer se = new SoftwareEngineer("software engineer");
		//DataScientist ds = new DataScientist("Data Scientist");
		//ProductManager pd = new ProductManager("Product Manager");
		
		Resume<SoftwareEngineer> p1 = new Resume<>("Manoj","Java",se);
		
		List<Resume<? extends JobRole>> list = new ArrayList<>();
		list.add(p1);
		
		HandleMultiplejobs.screening(list);
	}
}