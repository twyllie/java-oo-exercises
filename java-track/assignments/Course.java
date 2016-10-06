public class Course{
	private String name;
	private int credits;
	private int seatsLeft;
	private Student[] roster;
	
	public Course(String name, int credits, int seats){
		this.name = name;
		this.credits = credits;
		this.seatsLeft = seats;
		this.roster = new Student[seats];
	}
	
	public String getName(){
		return this.name;
	}
	public int getCredits(){
		return this.credits;
	}
	public int getRemainingSeats(){
		return this.seatsLeft;
	}
	
	public addStudents(){
		
	}
	public generateRoster(){
		
	}
	public averageGPA(){
		
	}
	public toString(){
		
	}
}