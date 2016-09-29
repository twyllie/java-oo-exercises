
public class Robot {
/** 
*	Excerise: It's Alive! for class 2 prep.
*/	
	private String name;
	private int posX, posY;
	private int speed;
	private int heading;
	
	public Robot(String name){
		this.name = name;
		this.posX = 0;
		this.posY = 0;
		this.speed = 5;
		this.heading = 0;
	}
	
	public void move(){
		/**
		 * Takes no arguments, and it moves the robot by it's speed.
		 */
		
		switch(this.heading){
			case 0: this.posY += this.speed;
					break;
			case 90: this.posX += this.speed;
					break;
			case 180: this.posY -= this.speed;
					break;
			case 270: this.posX -= this.speed;
					break;
			case 360: this.posY += this.speed;
		}
	}
	
	public void rotate(String dir){
		/**
		 * Takes a single letter argument for left(l) or right(r), and changes the robot's heading, thusly.
		 */
		
		if (dir == "r" || dir == "R"){
			this.heading = (this.heading + 90) % 360;
		}
		else{
			this.heading = (this.heading - 90) % 360;
		}
	}
	
	public double distanceToOtherBot(Robot other){
		/**
		 * Takes a single argument, another Robot instance, and returns the distance to it as an int.
		 */
		int diffX, diffY;
		double distance;
		
		diffX = this.posX - other.posX;
		diffY = this.posY - other.posY;
		distance = Math.sqrt((diffX*diffX)+(diffY*diffY));
		return distance;
	}
	
	public String toString(){
		/**
		 * Returns a string-ified output of the current attributes.
		 */
		return "name: "+this.name+" position: ("+this.posX+","+this.posY+") speed: "+this.speed+" heading: "+this.heading;
	}
	
	public static void main(String[] args){
		/**
		 * A simple test environment for our Robot.
		 */
		Robot skynet = new Robot("skynet");
		Robot terminator = new Robot("terminator");
		
	}
}