package Graphics;

import java.awt.image.BufferedImage;

public class Assets {

	/**
	 * Width of each sprite in the sprite sheet.
	 */
	private static final int width = 32;

	/**
	 * Height of each sprite in the sprite sheet.
	 */
	private static final int height = 32;

	/**
	 * Each different sprite in the sprite sheet.
	 */
	public static BufferedImage sword, sheild, grass, dirt, tree, rock;
	public static BufferedImage[] player_down, player_up, player_left, player_right, player_still;
	public static BufferedImage[] btn_start;
	

	/**
	 * Crops each sprite and sets them to their corresponding public variables.
	 */
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/test1.png"));
		SpriteSheet animations = new SpriteSheet(ImageLoader.loadImage("/textures/animation.png"));
		//Creates animation when moving
		player_down = new BufferedImage[3];
		player_up = new BufferedImage[3];
		player_left = new BufferedImage[3];
		player_right = new BufferedImage[3];
		player_still = new BufferedImage[1];

		player_down[0] = animations.crop(0, height * 2, width, height);
		player_down[1] = animations.crop(width, height * 2, width, height);
		player_down[2] = animations.crop(width * 2, height * 2, width, height);
		
		player_up[0] = animations.crop(0, 0, width, height);
		player_up[1] = animations.crop(width, 0, width, height);
		player_up[2] = animations.crop(width * 2, 0, width, height);
		
		player_left[0] = animations.crop(0, height, width, height);
		player_left[1] = animations.crop(width, height, width, height);
		player_left[2] = animations.crop(width * 2, height, width, height);
		
		player_right[0] = animations.crop(0, height * 3, width, height);
		player_right[1] = animations.crop(width, height * 3, width, height);
		player_right[2] = animations.crop(width * 2, height * 3, width, height);
		
		player_still[0] = animations.crop(width, height * 2, width, height);
		
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(width * 2, height *2, width * 2, height);
		btn_start[1] = sheet.crop(width * 2, height * 3, width * 2, height);
				
				
		// Crops certain sections of the sheet to make
		sword = sheet.crop(0, 0, width, height);
		grass = sheet.crop(width, 0, width, height);
		sheild = sheet.crop(width * 2, 0, width, height);
		dirt = sheet.crop(width * 3, 0, width, height);
		tree = sheet.crop(0, height, width * 2, height * 3);
		rock = sheet.crop(width * 2, height, width, height);
	}
}
