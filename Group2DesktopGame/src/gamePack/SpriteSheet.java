package gamePack;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage sprite;
	private int WIDTH, HEIGHT;
	
	public SpriteSheet(BufferedImage ss, int WIDTH, int HEIGHT)
	{
		this.sprite = ss;
		this.HEIGHT = HEIGHT;
		this.WIDTH = WIDTH;
	}

	public BufferedImage grabImage(int col, int row)
	{
		BufferedImage img = sprite.getSubimage( (col * WIDTH) - WIDTH, (row * HEIGHT) - HEIGHT, WIDTH, HEIGHT); 
		return img;
	}

}
