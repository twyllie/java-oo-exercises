
public class FabBot extends Robot{
	
	
	public FabBot(String name, int x, int y, int speed, int heading) {
		super(name, x, y, speed, heading);
	}
	
	public Furniture fabricate(){
		Furniture art = new Furniture(this.x, this.y);
		System.out.println("FabBot, " + this.getName() + ", made " + art);
		return art;
	}
	
	public void recieveCriticism(){
		System.out.println("Yeah, well, I'm not very good.");
	}
}
