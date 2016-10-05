
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
	private double qualityScore;
	
	//CONSTRUCTORS
	public Student(String first, String last, int id){
		this.firstName = first;
		this.lastName = last;
		this.id = id;
		this.credits = 0;
		this.gpa = 0;
		this.qualityScore = this.credits * this.gpa;
	}
	public Student(String first, String last, int id, int credits, double gpa){
		this.firstName = first;
		this.lastName = last;
		this.id = id;
		this.credits = credits;
		this.gpa = gpa;
		this.qualityScore = this.credits * this.gpa;
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
	
	//TODO: FIX ROUNDING
	public void submitGrade(double courseGrade, int courseCredit){
		double gpa;
		int temp;
		this.credits += courseCredit;
		this.qualityScore += (courseGrade * courseCredit);
		gpa = this.qualityScore/this.credits;
		temp = (int)(gpa * 1000);
		gpa = temp/1000.0;
		this.gpa = gpa;
	}
	
	//TODO: FIX ROUNDING
	public double computeTuition(){
		double amnt;
		amnt = 0;
		int temp;
		//Below 15 credits
		if (this.credits > 15){
			amnt = (this.credits*(20000.0/15));
			temp = (int)(amnt*100.0);
			amnt = temp/100.0;
			System.out.println(amnt);
			return amnt;
		}
		//Nominal semester
		else if (this.credits == 15){
			amnt += 20000.0;
			System.out.println(amnt);
			return amnt;
		}
		//More than 15 credits
		else{
			int credits = this.credits;
			amnt += 20000.0;
			credits -= 15;
			amnt += (credits*(20000.0/15));
			temp = (int)(amnt*100.0);
			amnt = temp/100.0;
			System.out.println(amnt);
			return amnt;
		}
	}
	public Student createLegacy(Student p1, Student p2){
		String bbFirst, bbLast;
		int bbID;
		double bbGPA;
		int bbCredits;
		
		bbFirst = p1.getName();
		bbLast = p2.getName();
		bbID = p1.getStudentID() + p2.getStudentID();
		
		
		//TODO: FIX ROUNDING
		bbGPA = (p1.getGPA() + p2.getGPA())/2;
		
		if (p1.getCredits() > p2.getCredits()){
			bbCredits = p1.getCredits();
		}else if (p1.getCredits() < p2.getCredits()){
			bbCredits = p2.getCredits();
		}else{
			bbCredits = p1.getCredits();
		}
		return new Student(bbFirst, bbLast, bbID, bbCredits, bbGPA);
	}
	public String toString(){
		return "Student: " + this.firstName + " " + this.lastName + " ID: " + this.id;
	}
	
	
}