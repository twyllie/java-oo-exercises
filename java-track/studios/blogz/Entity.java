package blogz;

abstract class Entity {
	
	private static int entityCount;
	private final int uid;
	
	public Entity(){
		entityCount++;
		this.uid = entityCount;
	}
	
	public int getUID(){
		return this.uid;
	}
}
