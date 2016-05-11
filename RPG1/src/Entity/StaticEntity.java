package Entity;

import RPG_Game.Handler;

public abstract class StaticEntity extends Entity {
	
	public static final int DEFAULT_ENTITY_WIDTH = 100;
	public static final int DEFAULT_ENTITY_HEIGHT = 100;

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

}
