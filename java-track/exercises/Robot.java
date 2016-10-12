
public class Robot {

	private String name;
	protected int x, y;
	protected int speed;
	protected int heading;
	
	
	public Robot(String name, int x, int y, int speed, int heading){
		this.name = name;
		this.x = x;
		this.y = y;
		this.speed = speed;
		if (heading >= 0 && heading <= 360){
			this.heading = heading;
		} else{
			this.heading = 0;
		}
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
	
	
	public void rotate(int rot){
		/**
		 * Takes a single int argument and rotates the robot by that amount, negative values are allowed.
		 */
		
		if (this.heading == 0){
			this.heading = 360;
		}
		
		if (rot >= -360 && rot <= 360){
			this.heading = (this.heading + rot) % 360;
		}
		else{
			return;
		}
	}
	
	public double distanceToBot(Robot other){
		/**
		 * Takes a single argument, another Robot instance, and returns the distance to it as a double.
		 */
		int diffX, diffY;
		double distance;
		
		diffX = this.x - other.getX();
		diffY = this.y - other.getY();
		distance = Math.sqrt((diffX*diffX)+(diffY*diffY));
		return distance;
	}
	
	public void setBehavior(RobotBehavior mood){
		
	}
	
	public String toString(){
		/**
		 * Returns a string-ified output of the current attributes.
		 */
		return "name: "+this.name+" position: ("+this.x+","+this.y+") speed: "+this.speed+" heading: "+this.heading;
	}
	
}