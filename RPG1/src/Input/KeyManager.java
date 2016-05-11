package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	/**
	 * Array of booleans to check to see which keys have been pressed.
	 */
	private boolean[] keys;

	/**
	 * Booleans for certain keys.
	 */
	public boolean up, down, left, right;

	public KeyManager() {
		keys = new boolean[256];
	}

	/**
	 * Sets boolean variables to true or false when they are pressed by the
	 * keyPressed and keyRealesed methods.
	 */
	public void update() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		System.out.println("pressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
