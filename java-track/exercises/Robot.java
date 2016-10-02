
public class Robot {
/** 
*	Excerise: It's Alive! for class 2 prep.
*/	
	private String name;
	private int x, y;
	private int speed;
	private int heading;
	
	public Robot(String name, int x, int y, int speed, int heading){
		this.name = name;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.heading = heading;
	}
	
	public String getName(){
		return this.name;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public int getSpeed(){
		return this.speed;
	}
	public int getHeading(){
		return this.heading;
	}
	
	public void move(){
		/**
		 * Takes no arguments, and it moves the robot by it's speed.
		 */
		
		switch(this.heading){
			case 0: this.y += this.speed;
					break;
			case 90: this.x += this.speed;
					break;
			case 180: this.y -= this.speed;
					break;
			case 270: this.x -= this.speed;
					break;
			case 360: this.y += this.speed;
		}
	}
	
	public void rotate(String dir){
		/**
		 * Takes a single letter argument for left(l) or right(r), and changes the robot's heading, thusly.
		 */
		
		if (this.heading == 0){
			this.heading = 360;
		}
		
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
		
		diffX = this.x - other.getX();
		diffY = this.y - other.getY();
		distance = Math.sqrt((diffX*diffX)+(diffY*diffY));
		return distance;
	}
	
	public String toString(){
		/**
		 * Returns a string-ified output of the current attributes.
		 */
		return "name: "+this.name+" position: ("+this.x+","+this.y+") speed: "+this.speed+" heading: "+this.heading;
	}
	
//	public static void main(String[] args){
//		/**
//		 * A simple test environment for our Robot.
//		 */
//		Robot skynet = new Robot("skynet");
//		Robot terminator = new Robot("terminator");
//		System.out.println(skynet);
//		System.out.println(terminator);
//		skynet.move();
//		terminator.rotate("l");
//		System.out.println(skynet);
//		System.out.println(terminator);
//		System.out.println(skynet.distanceToOtherBot(terminator));
//		
//	}
}