
public class StoryTeller implements RobotBehavior {
	public void doNextMove(StoryBot storybot){
		
		
		
		
		//Randomly decide whether or not to rotate, and if so which direction.
		if((int)(Math.random()*1)+1 == 1){
			if((int)(Math.random()*1)+1 == 1){
				storybot.rotate(90);
			}else{
				storybot.rotate(-90);
			}
		}
			
		//Randomly decide to move or not.
		if((int)(Math.random()*1)+1 == 1){
			storybot.move();		
		}
		
	}
}
