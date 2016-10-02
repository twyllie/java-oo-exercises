public class Fraction {
/**
 * A class for storing and manipulating fractions.
 * Requires two fields:
 * Fraction(int num, int denom)
 */
	
	private int num, denom;
	
	public Fraction(int num, int denom){
		this.num = num;
		this.denom = denom;
	}
	
	public int getNum(){
		return this.num;
	}
	
	public int getDenom(){
		return this.denom;
	}
	
	public  Fraction add(Fraction other){
		int newNum, newDenom;
		newNum = this.num + other.getNum();
		newDenom = this.denom + other.getDenom();
		return new Fraction(newNum, newDenom);
	}
	
	public Fraction multiply(Fraction other){
		int newNum, newDenom;
		newNum = this.num * other.denom;
		newDenom = this.denom * other.num;
		return new Fraction(newNum, newDenom).simplify();
	}
	
	public Fraction flip(){
		return new Fraction(this.denom, this.num);
	}
	
	public int gcd(int num, int denum){
		int m, n, oldn, oldm;
		m = num;
		n = denum;
		while(m % n != 0){
			oldm = m;
			oldn = n;
			
			m = oldn;
			n = oldm % oldn;
		}
		return n;
	}
	
	public Fraction simplify(){
		int newNum, newDenom, gcd;
		gcd = this.gcd(this.num, this.denom);
		newNum = this.num / gcd;
		newDenom = this.denom / gcd;
		return new Fraction(newNum, newDenom);
	}
	
	public String toString(){
		return this.num + "/" + this.denom;
	}
}
