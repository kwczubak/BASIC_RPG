package RPG_Game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import Display.Display;
import Display.GameCamera;
import Graphics.Assets;
import Input.KeyManager;
import Input.MouseManager;
import States.GameState;
import States.MenuState;
import States.State;

public class Game implements Runnable {

	/**
	 * Display that creates the window.
	 */
	private Display display;

	/**
	 * Thread that runs the game.
	 */
	private Thread thread;

	/**
	 * Width and height of the window.
	 */
	private int width, height;
	/**
	 * Checks if game is running or not. Set to false.
	 */
	private boolean running = false;
	/**
	 * Title of the game.
	 */
	private String title;
	/**
	 * Buffer that helps create less static when the game runs.
	 */
	private BufferStrategy bs;
	/**
	 * Lets us create graphics on the canvas.
	 */
	private Graphics g;

	/**
	 * States that this game will use.
	 */
	public State gameState, menuState;

	/**
	 * Key manager for what keys are pressed.
	 */
	private KeyManager keymanager;
	private MouseManager mouseManager;
	
	private GameCamera gameCamera;
	
	private Handler handler;

	/**
	 * Creates a 2D Tile RPG game.
	 * 
	 * @param title
	 *            Title of the game.
	 * @param width
	 *            Width of the window.
	 * @param height
	 *            Height of the window.
	 */
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		keymanager = new KeyManager();
		mouseManager = new MouseManager();
	}

	/**
	 * Initializes the game.
	 */
	private void init() {
		// Creates window.
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keymanager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		// Creates assets.
		Assets.init();
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);

		// Creates the states
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(menuState);
	}

	/**
	 * Updates the game.
	 */
	private void update() {
		// calls update to keyManager to see if a key was pressed.
		keymanager.update();
		// Updates a state if there is a state to update.
		if (State.getState() != null) {
			State.getState().update();
		}
	}

	/**
	 * Renders the game.
	 */
	private void render() {
		// Buffers game so that game does not *flicker*.
		bs = display.getCanvas().getBufferStrategy();
		// Creates buffers.
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}

		g = bs.getDrawGraphics();
		// Clear screen
		g.clearRect(0, 0, width, height);
		// Start drawing.

		// Draws whatever is in the current state.
		if (State.getState() != null) {
			State.getState().render(g);
		}
		// End drawing.
		bs.show();
		g.dispose();
	}

	/**
	 * Runs the game when thread.start() in start is called and runs until
	 * thread.join() in stop is called.
	 */
	@Override
	public void run() {
		// Initializes our game.
		init();

		// How many times we run the update and render methods.
		int fps = 60;
		// There are 1 billion nanoseconds in a second.
		double timePerTick = 1000000000 / fps;
		// Delta is the difference between now and the last time it has been
		// called.
		double delta = 0;
		long now;
		// Returns the current time on the computer in nanoseconds.
		long lastTime = System.nanoTime();
		// These are for printing out the fps.
		long timer = 0;
		int ticks = 0;

		while (running) {
			// Current time of computer.
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			// If it has been a second.
			if (delta >= 1) {
				update();
				render();
				ticks++;
				delta--;
			}
			// Every second prints out how many times the methods has been
			// called. Should be the same as fps.
			if (timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}

	/**
	 * Starts the thread of the game.
	 */
	public synchronized void start() {
		// If game already running don't start again.
		if (running)
			return;

		running = true;
		// thread equals this(Game) to run.
		thread = new Thread(this);
		// Starts the thread by calling the run() method.
		thread.start();
	}

	/**
	 * Stops the thread of the game.
	 */
	public synchronized void stop() {
		// If game already not running then don't stop.
		if (!running)
			return;

		running = false;
		// thread.join needs try catch to call and then stops the thread.
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the title of the window.
	 * 
	 * @return the title.
	 */
	public String getTitle() {
		return title;
	}

	public KeyManager getKeyManager() {
		return keymanager;
	}
	
	public MouseManager getMouseManager(){
		return mouseManager;
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	public State getState(){
		return State.getState();
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
