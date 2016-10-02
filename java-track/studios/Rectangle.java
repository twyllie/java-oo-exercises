public class Rectangle {
/**
 * A class for storing the data that defines a rectangle.
 * Requires two fields.
 * Rectangle(int length, int width)
 */
	
	private int length, width;
	
	public Rectangle(int length, int width){
		this.length = length;
		this.width = width;
	}
	
	public float area(){
		return this.length * this.width;
	}
	
	public float perimeter(){
		return (this.length*2) + (this.width*2);
	}
	
	public boolean compareSize(Rectangle other){
		if (this.area() < other.area()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isSqaure(){
		if (this.length == this.width){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String toString(){
		if (this.isSqaure() == true){
			return "Square with sides: "+this.length+" long."; 
		}else{
			return "Rectangle with width: "+this.width+" and length: "+this.length+".";
		}
	}
}
