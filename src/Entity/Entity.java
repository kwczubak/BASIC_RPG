package Entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import RPG_Game.Handler;

public abstract class Entity {

	/**
	 * The positions of an entity.
	 */
	protected float x, y;
	protected Handler handler;
	protected int width, height;
	protected Rectangle bounds;

	/**
	 * Constructs an entity with a given position.
	 * 
	 * @param x
	 *            x position of entity.
	 * @param y
	 *            y position of entity.
	 */
	public Entity(Handler handler, float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.handler = handler;
		
		bounds = new Rectangle(0, 0, width, height);
	}

	public abstract void update();

	public abstract void render(Graphics g);
	
	public boolean checkEntityCollisions(float xOffset, float yOffset){
		for(Entity e : handler.getLevel().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))){
				return true;
			}
		}
		return false;
	}
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset){
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
}
