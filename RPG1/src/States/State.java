package States;

import java.awt.Graphics;

import RPG_Game.Handler;

public abstract class State {

	/**
	 * The current state that the game is at.
	 */
	private static State currentState = null;

	/**
	 * Sets the state parameter as the current state.
	 * 
	 * @param state
	 *            The current state the game is in.
	 */
	public static void setState(State state) {
		currentState = state;
	}

	/**
	 * Gets the state that the game is currently in.
	 * 
	 * @return
	 */
	public static State getState() {
		return currentState;
	}

	// CLASS
	/**
	 * A game variable for this class.
	 */
	protected Handler handler;

	/**
	 * Constructs a game to the state.
	 * 
	 * @param game
	 */
	public State(Handler handler) {
		this.handler = handler;
	}

	/**
	 * Updates the state whenever called.
	 */
	public abstract void update();

	/**
	 * Renders the state whenever called.
	 * 
	 * @param g
	 *            Graphics that we can use to render.
	 */
	public abstract void render(Graphics g);
}
