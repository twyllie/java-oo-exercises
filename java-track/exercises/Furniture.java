
public class Furniture {

	private String type;
	private int height;
	private int width;
	private int x;
	private int y;
	
	public Furniture(int x, int y){
		int selector = (int)((Math.random() * 5) + 1);
		
		switch(selector){
		case 1: this.type = "Chair";
			break;
		case 2: this.type = "Cabinet";
			break;
		case 3: this.type = "Couch";
			break;
		case 4: this.type = "Bed";
			break;
		case 5: this.type = "Table";
			break;
		default: this.type = "Failure";
		}
		
		if(this.type != "Failure"){
			this.height = (int)((Math.random() * 100) + 1);
		}else{
			this.height = (int)((Math.random() * 100000) + 1);
		}
		
		if(this.type != "Failure"){
			this.width = (int)((Math.random() * 100) + 1);
		}else{
			this.width = (int)((Math.random() * 3) + 1);
		}
		this.x = x;
		this.y = y;
	}
	
	public String getType(){
		return this.type;
	}
	public int getHeight(){
		return this.height;
	}
	public int getWidth(){
		return this.width;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	
	public String toString(){
		return "a "+this.type+" "+this.height+"in. high, and "+this.width+"in. wide. At (" + this.x + ", " + this.y + ").";
	}
}
