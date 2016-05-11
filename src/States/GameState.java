package States;

import java.awt.Graphics;

import Entity.Player;
import Levels.Level;
import RPG_Game.Handler;

public class GameState extends State {

	private Level level;

	/**
	 * Constructs a game state with a new player.
	 * 
	 * @param game
	 *            The game where this state is going to.
	 */
	public GameState(Handler handler) {
		super(handler);
		level = new Level(handler, "resources/level/level1.txt");
		handler.setLevel(level);
	}

	@Override
	public void update() {
		level.update();
	}

	@Override
	public void render(Graphics g) {
		level.render(g);
	}

}
