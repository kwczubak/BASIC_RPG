package Graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	/**
	 * Sprite sheet image
	 */
	private BufferedImage sheet;

	/**
	 * Creates a sprite sheet using an image given.
	 * 
	 * @param sheet
	 *            Sprite sheet
	 */
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}

	/**
	 * Crops an sprite sheet to get 1 sprite.
	 * 
	 * @param x
	 *            Starting x axis pixel
	 * @param y
	 *            Starting y axis pixel
	 * @param width
	 *            Width of the sprite
	 * @param height
	 *            Height of the sprite
	 * @return one sprite inside a sprite sheet
	 */
	public BufferedImage crop(int x, int y, int width, int height) {
		// Crops a picture to create another picture.
		return sheet.getSubimage(x, y, width, height);
	}
}
