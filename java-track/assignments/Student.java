
public class Student{
	/**
	 * Student class
	 */
	
	//FIELDS
	private String firstName;
	private String lastName;
	private int	id;
	private int credits;
	private double gpa;
	
	//CONSTRUCTOR
	public Student(String first, String last, int id){
		this.firstName = first;
		this.lastName = last;
		this.id = id;
		this.credits = 0;
		this.gpa = 0;
	}
	
	
	//GETTERS
	public String getName(){
		return this.firstName+" "+this.lastName;
	}
	
	public int getStudentID(){
		return this.id;
	}
	
	public int getCredits(){
		return this.credits;
	}
	
	public double getGPA(){
		return this.gpa;
	}
	
	
	//METHODS
	public String getClassStanding(){
		
	}
	public void submitGrade(double grade, int credits){
		
	}
	public double computeTuition(){
		
	}
	public void createLegacy(Student other){
		
	}
	public String toString(){
		return "";
	}
	
	
}