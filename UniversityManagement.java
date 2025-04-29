import java.util.List;
import java.util.ArrayList;

abstract class CourseType{
	private String type;
	
	CourseType(String type){
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
}

class ExamCourse extends CourseType{
	ExamCourse(String type){
		super(type);
	}
}

class AssignmentCourse extends CourseType{
	AssignmentCourse(String type){
		super(type);
	}
}

class ResearchCourse extends CourseType{
	ResearchCourse(String type){
		super(type);
	}
}

class Course<T extends CourseType>{
	private String title;
	private String instructor;
	private T coursetype;
	
	Course(String title, String instructor, T coursetype){
		this.title = title;
		this.instructor = instructor;
		this.coursetype = coursetype;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getInstructor(){
		return instructor;
	}
	
	public void setInstructor(String instructor){
		this.instructor = instructor;
	}
	
	public T getCourseType(){
		return coursetype;
	}
	
	public void displayDetails(){
		System.out.println("Title: "+title);
		System.out.println("Instructor: "+instructor);
		System.out.println("Course: "+coursetype.getType());
	}
}

class CourseUtils{
	public static void displayAllCourses(List<? extends Course> courses){
		for(Course course : courses){
			course.displayDetails();
		}
	}
}

public class UniversityManagement{
	public static void main(String[] a){
		ExamCourse ec = new ExamCourse("Java");
		AssignmentCourse ac = new AssignmentCourse("DSA");
		ResearchCourse rc = new ResearchCourse("SpringBoot");
		
		Course<ExamCourse> ecourse = new Course<>("Java basics", "Prakash", ec);
		Course<AssignmentCourse> acourse = new Course<>("DSA Arrays", "Sunil", ac);
		Course<ResearchCourse> rcourse = new Course<>("Database", "Sukhmohan", rc);
		
		List<Course> allCourses = new ArrayList<>();
		allCourses.add(ecourse);
		allCourses.add(acourse);
		allCourses.add(rcourse);
		
		CourseUtils.displayAllCourses(allCourses);
	}
}