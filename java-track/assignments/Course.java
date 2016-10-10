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
	
	public boolean addStudent(Student st){
		if(this.seatsLeft <= 0){
			return false;
		}
		
		for(int i = 0; i < roster.length; i++){
			if(roster[i] instanceof Student){
				if(st.getName() == roster[i].getName()){
					return false;
				}
			}else{
				roster[i] = st;
				this.seatsLeft -= 1;
				return true;
			}
		}
		
		return false;
	}
	public String generateRoster(){
		String output;
		output = "";
		for (int i = 0; i < roster.length; i++){
			if(roster[i] instanceof Student){
				output += (i+1) + ": "  + roster[i].getName() + "\n";
			}
		}
		return output;
	}
	public double averageGPA(){
		int students = 0;
		double gpatotal = 0;
		double output = 0;
		for (int i = 0; i < roster.length; i++){
			if(roster[i] instanceof Student){
				gpatotal += roster[i].getGPA();
				students++;
			}
		}
		output = gpatotal/students;
		return output;
	}
	public String toString(){
		return "Course:" + this.name + " Credits: " + this.credits; 
	}
}