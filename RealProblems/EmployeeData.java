import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee{
    static int counter = 1;
    int id;
    String name;
    String department;
    double salary;

    Employee(String name, String department, double salary){
        this.id = counter++;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "- " + name + "- " + department + "- " + salary;
    }
}
public class EmployeeData {

    public static void filteredByDep(List<Employee> e){
        System.out.println("Highest paid persons in the department: ");
        e.stream().filter(e1->e1.department=="ECE" && e1.salary > 80000)
                .forEach(System.out::println);
        System.out.println();
    }

    public static void sortBysalary(List<Employee> e){
        System.out.println("Sorted by Salary: ");
        e.stream()
                .sorted((e1, e2)->Double.compare(e2.salary, e1.salary))
                .forEach(System.out::println);
        System.out.println();
    }

    public static void groupByDep(List<Employee> e){
        Map<String, List<Employee>> grouped = e.stream()
                .collect(Collectors.groupingBy(e1-> e1.department));

        grouped.forEach((dep, emplist)->{
            System.out.println("\nDepartment: "+dep);
            emplist.forEach(System.out::println);
        });
    }

    public static void averageSalByDep(List<Employee> e) {
        System.out.println("Average Salary by Department:");

        Map<String, Double> averageSalaries = e.stream()
                .collect(Collectors.groupingBy(
                        emp -> emp.department,
                        Collectors.averagingDouble(emp -> emp.salary)
                ));
        averageSalaries.forEach((dept, avgSalary) ->
                System.out.println(dept + " : $" + avgSalary));
    }

    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(
                new Employee("Manoj", "CSE", 20000),
                new Employee("Deekshith", "ECE", 90000),
                new Employee("Raj", "CSE", 50000),
                new Employee("Raghu", "ECE", 45000)
        );

        filteredByDep(list);
        sortBysalary(list);
        groupByDep(list);
        averageSalByDep(list);
    }
}
