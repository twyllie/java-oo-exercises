
public class Builder implements RobotBehavior{
	
	//Builder's goal is to build a house, he must first have built all 5 different pieces of furniture, in different locations.
	
	private Furniture[] made;
	
	public Builder(){
		made = new Furniture[5];
	}
	
	
	public boolean doNextMove(FabBot fabbot, Robot[] others){
		Furniture art;
		art = fabbot.fabricate();
		boolean contains = false;
		boolean spotTaken = false;
		int full = 0;
		boolean finished = false;
		
		//Checks to make sure that the new furniture is not already built, or in the same spot as another.
		for(int i=0; i < this.made.length; i++){
			if(this.made[i].getType() == art.getType()){
				contains = true;
			}else if (this.made[i].getX() == art.getX() && this.made[i].getY() == art.getY()){
				spotTaken = true;
			}
		}
		
		
		//Adds the furniture if it is unique, and in a new spot.
		if(contains == false && spotTaken == false){
			for(int i=0; i < this.made.length; i++){
				if(this.made[i] == null){
					this.made[i] = art;
				}else if(this.made[i].getType() != art.getType()){
					this.made[i] = art;
				}else{
					full++;
				}
			}
			if(full == 5){
				finished = true;
			}
		}
		
		//Randomly decide whether or not to rotate, and if so which direction.
		if((int)(Math.random()*1)+1 == 1){
			if((int)(Math.random()*1)+1 == 1){
				fabbot.rotate(90);
			}else{
				fabbot.rotate(-90);
			}
		}
			
		//Randomly decide to move or not.
		if((int)(Math.random()*1)+1 == 1){
			fabbot.move();		
		}
		
		//Check to see if FabBot met its goal.
		if(finished == true){
			return true;
		}else{
			return false;
		}
	}
}
