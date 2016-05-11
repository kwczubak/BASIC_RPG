package Graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	/**
	 * Loads an image from a folder.
	 * 
	 * @param path
	 *            The path of the picture
	 * @return the image from the path or null if it couldn't find the image.
	 */
	public static BufferedImage loadImage(String path) {
		// Returns image that you called for. Get error without the try catch.
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
