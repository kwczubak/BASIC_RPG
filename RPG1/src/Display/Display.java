package Display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {

	/**
	 * Variable to create a window.
	 */
	private JFrame frame;
	/**
	 * Canvas to draw on in the window from the JFrame.
	 */
	private Canvas canvas;

	/**
	 * Title of the window.
	 */
	private String title;
	/**
	 * Width of the window.
	 */
	private int width;
	/**
	 * Height of the window.
	 */
	private int height;

	/**
	 * Creates a window to play the game on.
	 * 
	 * @param title
	 *            Title of the window
	 * @param width
	 *            Width of the window
	 * @param height
	 *            Height of the window
	 */
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		createDisplay();
	}

	/**
	 * Creates the window that is called from the constructor.
	 */
	private void createDisplay() {
		frame = new JFrame(title);
		// Sets the size of the window.
		frame.setSize(width, height);
		// Closes window when pressing the X.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Doesn't allow user to resize the screen.
		frame.setResizable(false);
		// Sets the screen visible.
		frame.setVisible(true);
		// Centers the window.
		frame.setLocationRelativeTo(null);

		canvas = new Canvas();
		// Creates canvas as the same size as the window.
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		// Allows keyboard input to canvas. Some computers work without this but
		// some dont work at all.
		canvas.setFocusable(false);

		// Adds canvas to window and packs the canvas into the window.
		frame.add(canvas);
		frame.pack();
	}

	/**
	 * Returns the canvas from this window.
	 * 
	 * @return the canvas.
	 */
	public Canvas getCanvas() {
		return canvas;
	}

	/**
	 * Gets the width of the window.
	 * 
	 * @return the width.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Gets the height of the window.
	 * 
	 * @return the height.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Gets the JFrame.
	 * 
	 * @return the JFrame
	 */
	public JFrame getFrame() {
		return frame;
	}
}
