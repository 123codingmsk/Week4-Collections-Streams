import java.util.*;
import java.io.*;

class Employee implements Serializable{
	static int counter = 0;
	int id;
	String name;
	String department;
	int salary;
	
	Employee(String name, String department, int salary){
		this.id = ++counter;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	
	@Override
	public String toString(){
		return "id = "+id+" name = "+name+" department = "+department+" salary = "+salary+"\n";
	}
}

public class Serialization{
	
	public static void serialize(List<Employee> employees){
		try(ObjectOutputStream oos = new ObjectOutputStream
			(new FileOutputStream("employees.ser"))){
			
			//converting object to binary format
			oos.writeObject(employees);
			System.out.println("Employees are seriaized");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void deserialize(){
		try(ObjectInputStream ois = new ObjectInputStream
			(new FileInputStream("employees.ser"))){
			
			// we r converting binary format to objects
			List<Employee> deserializeEmps = (List<Employee>) ois.readObject();
			System.out.println("Deserialized objects: "+deserializeEmps);
		}catch(IOException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] a){
		Employee emp1 = new Employee("Manoj", "IT", 30000);
		Employee emp2 = new Employee("Deekshith", "CEO", 3000000);
		Employee emp3 = new Employee("Rajesh", "Management", 10000);
		List<Employee> employees = new ArrayList<>();
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		
		serialize(employees);
		deserialize();
	}
}