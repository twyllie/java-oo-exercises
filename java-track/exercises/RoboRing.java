
public class RoboRing {

	public static void main(String[] args) {
		/**
		 * The place where Robots go to COMPETE!!!!!
		 * WELCOME TO THE THUNDERDOME!!!!!!!!!!!!!!!
		 */
		
		int x1, x2, y1, y2, s1, s2;
		x1 = (int)(Math.random() * 100)+ 1; //Random value, 1-100
		x2 = (int)(Math.random() * 100)+ 1; //Random value, 1-100
		y1 = (int)(Math.random() * 100)+ 1; //Random value, 1-100
		y2 = (int)(Math.random() * 100)+ 1; //Random value, 1-100
		s1 = (int)(Math.random() * 10)+ 1; //Random value, 1-10
		s2 = (int)(Math.random() * 10)+ 1; //Random value, 1-10
		
		//initializing objects
		StoryBot aesop = new StoryBot("Aesop", x1, y1, s1, 360);
		FabBot davinci = new FabBot("Da Vinci", x2, y2, s2, 360);
		StoryTeller fables = new StoryTeller();
		Builder opus = new Builder();
		Robot[] others = new Robot[2];
		others[0] = aesop;
		others[1] = davinci;
		
		
		//initializing loop condition variables
		boolean aesopB = false, davinciB = false;
		
		
		do{
			aesopB = fables.doNextMove(aesop, others);
			davinciB = opus.doNextMove(davinci, others);
		}while(aesopB == false && davinciB == false);
		
		if(aesopB == true){
			System.out.println(aesop.getName() + " Bot has told his tale, and the jig is up.");
		}
		
		if(davinciB == true){
			System.out.println(davinci.getName() + " Bot has built his home, and is settling down.");
		}
	}

}
