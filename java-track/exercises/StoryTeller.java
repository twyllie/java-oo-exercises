
public class StoryTeller implements RobotBehavior{
	
	@Override
	public boolean doNextMove(StoryBot storybot, Robot[] others){
		
		boolean hasMoved = false;
		
		//Needs to check and see  if there are other robots relatively nearby.
		for(int i = 0; i < others.length; i++){
			if(others[i].getName() != storybot.getName()){
				//If a bot is close enough, tell it a story.
				if(storybot.distanceToBot(others[i]) < 5){
					storybot.tellStory();
					return true;
				}
				
				//Else if a bot is close enough to notice, but not engage, move closer to it.
				else if(storybot.distanceToBot(others[i]) < 30){
					//Get the differences to determine which axis is most productive to move on.
					int xdiff = storybot.getX() - others[i].getX();
					int ydiff = storybot.getY() - others[i].getY();
					//See which is greater
					if (xdiff > ydiff){
						//Is the other bot above storybot?
						if(storybot.getX() > others[i].getX()){
							storybot.rotate(360-storybot.getHeading());
							storybot.move();
						}
						//Then maybe it's below it?
						else{
							storybot.rotate(180-storybot.getHeading());
							storybot.move();
						}
					}else{
						//Is the other bot right of storybot?
						if(storybot.getY() > others[i].getY()){
							storybot.rotate(90-storybot.getHeading());
							storybot.move();
						}
						//The maybe it's to the left?
						else{
							storybot.rotate(270-storybot.getHeading());
							storybot.move();
						}
					}
					hasMoved = true;
				}
				
				//If storybot, can't tell a story it engages in self-destructive behavior.
				else{
					storybot.recieveCriticism();
				}
			}
		}
		
		//If it has not already moved, move randomly.
		if(hasMoved == false){
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
		return false;
	}
}
