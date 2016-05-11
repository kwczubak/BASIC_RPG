package Entity;

import java.awt.Graphics;

import Graphics.Assets;
import RPG_Game.Handler;
import Tile.Tile;

public class Tree extends StaticEntity {

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, StaticEntity.DEFAULT_ENTITY_WIDTH, StaticEntity.DEFAULT_ENTITY_HEIGHT);
		
		bounds.x = 25;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 90;
		bounds.height = (int) (height - height / 1.5f) - 20;
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), null);
	}

}
