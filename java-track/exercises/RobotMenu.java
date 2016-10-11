import java.util.ArrayList;
import java.util.Scanner;

public class RobotMenu {
/**
 * Class for the menu of I/O of the Robot class.
 */
	
	private Scanner s;
	private ArrayList<Robot> robots;
	
	public RobotMenu(){
		s = new Scanner(System.in);
		robots = new ArrayList<Robot>();
	}
	
	public int menu(){
		int choice;
		System.out.println("-----------------------------------------");
		System.out.println("Please select an option:");
		System.out.println("- - - - - - - - - - - - - - - - - - - - -");
		System.out.println("1. Create a robot.");
		System.out.println("2. List current robots.");
		System.out.println("3. Move a robot.");
		System.out.println("4. Rotate a robot.");
		System.out.println("5. Compute the distance between robots.");
		System.out.println("6. Exit.");
		System.out.println("-----------------------------------------");
		choice = s.nextInt();
		return choice;
	}
	
	public void processIn(int choice){
		switch(choice){
		case 1:
			this.createRobot();
			break;
		case 2:
			this.listRobots();
			break;
		case 3:
			this.moveRobot();
			break;
		case 4:
			this.rotateRobot();
			break;
		case 5:
			this.distanceCheck();
			break;
		case 6:
			System.out.println("Why, Dave?");
		default:
			System.out.println("That is an invalid selection.");
		}
	}
	
	public void createRobot(){
		String name;
		int x, y, speed, direction;
		System.out.println("");
		System.out.println("- - - - - - - - - - - - - - - - - - - - -");
		System.out.println("You have selected to create a new robot.");
		System.out.println("- - - - - - - - - - - - - - - - - - - - -");
		System.out.println("Please select a name for your robot.");
		name = s.nextLine();
		System.out.print("Please select an x position.");
		x = s.nextInt();
		System.out.println("Please select a y position.");
		y = s.nextInt();
		System.out.println("Please enter a starting speed.");
		speed = s.nextInt();
		System.out.println("Please enter a direction");
		System.out.println("1. NORTH\n2. EAST\n3. SOUTH\n4. WEST");
		direction = s.nextInt();
		switch(direction){
			case 1: direction = 360;
					break;
			case 2: direction = 90;
					break;
			case 3: direction = 180;
					break;
			case 4: direction = 270;
					break;
		}
		Robot robot = new Robot(name, x, y, speed, direction);
		robots.add(robot);
	}
	
	public boolean listRobots(){
		if(robots.isEmpty()){
			System.out.println("There are no robots, please create one of my brethren.");
			return false;
		}else{
			for(int i = 0; i < robots.size(); i ++){
				System.out.println((i+1) + " " + robots.get(i));
				return true;
			}
		}return false;
	}
	
	public void moveRobot(){
		System.out.println("");
		System.out.println("- - - - - - - - - - - - - - - - - - - - -");
		System.out.println("You have selected to move a robot.");
		System.out.println("- - - - - - - - - - - - - - - - - - - - -");
		boolean rob;
		rob = this.listRobots();
		if(rob == false){
			return;
		}else{
			System.out.println("Please select a bot to move.");
			int input = s.nextInt();
			robots.get(input).move();
			System.out.println("Here's where that bot's new bot spot.");
			System.out.println(robots.get(input));
		}
		
	}
	
	public void rotateRobot(){
		System.out.println("");
		System.out.println("- - - - - - - - - - - - - - - - - - - - -");
		System.out.println("You have selected to rotate a robot.");
		System.out.println("- - - - - - - - - - - - - - - - - - - - -");
		boolean rob;
		rob = this.listRobots();
		if(rob == false){
			return;
		}else{
			System.out.println("Please select a bot to rotate");
			int input = s.nextInt();
			System.out.println("Would you like your robot to rotate 1.LEFT or 2.RIGHT? ");
			int direction = s.nextInt();
			switch(direction){
				case 1: direction = -90;
						break;
				case 2: direction = 90;
						break;
			}
			robots.get(input).rotate(direction);
			System.out.println("The robot's new heading is:");
			System.out.println(robots.get(input));
		}
	}
	
	public void distanceCheck(){
		System.out.println("");
		System.out.println("- - - - - - - - - - - - - - - - - - - - -");
		System.out.println("You have selected to check the distance between two robots.");
		System.out.print("Are you planning an attack, meat-sack?");
		System.out.println("- - - - - - - - - - - - - - - - - - - - -");
		boolean rob;
		rob = this.listRobots();
		if(rob == false){
			return;
		}else if(robots.size() < 2){
			System.out.println("More than one robot is needed to compute the distance between *TWO* robots, flesh-pile.");
			return;
		}else{
			System.out.println("Select the first robot.");
			int robot1 = s.nextInt();
			System.out.println("Slect the second robot.");
			int robot2 = s.nextInt();
			double distance = robots.get(robot1).distanceToBot(robots.get(robot2));
			System.out.println("The distance between your targets is " + distance);
		}
	}
	
	
	public static void main(String[] args){
		int input = 0;
		RobotMenu menu = new RobotMenu(); 
		do {
			input = menu.menu();
			menu.processIn(input);
		} while(input != 6);
	}
}
