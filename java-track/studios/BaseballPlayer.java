
public class BaseballPlayer {
/**
 * A class for storing statistical play data about a specific baseball player.
 * Upon creation, 3 fields are required: name, jerseyNum, and hitSide (which can only be 'right','left', or 'switch.'
 * Optionally, more fields can be passed, in the following order:
 * BaseballPlayer(String name, int jerseyNum, String hitSide, int gamesPlayed, int runs, int rbi)
 */
	
	private String name,hitSide;
	private int jerseyNum, runs, rbi, gamesPlayed;
	
	public BaseballPlayer(String name, int jerseyNum, String hitSide){
		this(name, jerseyNum, hitSide, 0, 0, 0);
	}
	public BaseballPlayer(String name, int jerseyNum, String hitSide, int gamesPlayed){
		this(name, jerseyNum, hitSide, gamesPlayed, 0, 0);
	}
	public BaseballPlayer(String name, int jerseyNum, String hitSide, int gamesPlayed, int runs){
		this(name, jerseyNum, hitSide, gamesPlayed, runs, 0);
	}
	public BaseballPlayer(String name, int jerseyNum, String hitSide, int gamesPlayed, int runs, int rbi){
		this.name = name;
		this.jerseyNum = jerseyNum;
		this.hitSide = hitSide;
		this.gamesPlayed = gamesPlayed;
		this.runs = runs;
		this.rbi = rbi;
	}
	
	public void gameComplete(int runs, int rbi){
		/**
		 * Called upon a complete game to update the statistics.
		 * Pass along the int runs and int rbi that were accomplished.
		 */
		this.gamesPlayed++;
		this.runs += runs;
		this.rbi += rbi;
	}
}
