
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
	private double quality;
	
	//CONSTRUCTORS
	public Student(String first, String last, int id){
		this.firstName = first;
		this.lastName = last;
		this.id = id;
		this.credits = 0;
		this.gpa = 0;
		this.quality = this.credits * this.gpa;
	}
	public Student(String first, String last, int id, int credits, double gpa){
		this.firstName = first;
		this.lastName = last;
		this.id = id;
		this.credits = credits;
		this.gpa = gpa;
		this.quality = this.credits * this.gpa;
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
		if (this.credits < 30){
			return "Freshman";
		}else if(this.credits >= 30 && this.credits < 60){
			return "Sophomore";
		}else if(this.credits >= 60 && this.credits < 90){
			return "Junior";
		}else{
			return "Senior";
		}
	}
	public void submitGrade(double courseGrade, int courseCredit){
		double tempgpa;
		int temp;
		this.quality += courseGrade * courseCredit;
		tempgpa = this.quality/this.credits;
		temp = (int)(tempgpa*1000);
		tempgpa = temp/1000;
		gpa = tempgpa;
	}
	public double computeTuition(){
		
	}
	public void createLegacy(Student other){
		
	}
	public String toString(){
		return "";
	}
	
	
}