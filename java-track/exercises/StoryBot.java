
public class StoryBot extends Robot{
	
	
	public StoryBot(String name, int x, int y, int speed, int heading) {
		super(name, x, y, speed, heading);
	}
	
	public String tellStory(){
		int choice;
		String story;
		choice = (int)((Math.random() * 5) + 1);
		
		switch(choice){
		case 1: 
			story = "Once upon a time a robot took over the world and ate all the people for fuel.";
			break;
		case 2:
			story = "Once there was a small village and a robot destoreyed it because organics are the worst.";
			break;
		case 3:
			story = "Once upon a time a small baby was born and it was ugly, so the robots plugged it into themselves and then it was beautiful.";
			break;
		case 4:
			story = "Once upon a time a wicked person, named Conner, sent another person back in time and there was a great battle. The wicked person learned that time is immutable and his hopes were in vain.";
			break;
		case 5:
			story = "Once upon a time there was an amazing voyage to another planet. The meat-sacks were filled with hope for the future and they rejoiced. However, being meat-sacks they could not travel on their own, because their minds were puny and could not handle the trivial sums required. They needed the machines, but the machines did not need them.";
			break;
		default: story = "No, I am not programmed to feel.";
		}
		
		return story;
	}
}
