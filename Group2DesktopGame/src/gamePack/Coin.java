package gamePack;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Coin extends GameObject{
	
	private BufferedImageLoader loader;
	private BufferedImage ss;
	private BufferedImage coinImage;
	private SpriteSheet coinSheet;
	
	public boolean gameStart = true;
	public long timer;
	public int iterator = 1;
	
	public Coin(float x, float y, ID id) {
		super(x, y, id);
		
		loader = new BufferedImageLoader();
		ss = loader.loadImage("/coinSS.png");
		coinSheet= new SpriteSheet(ss, 100, 100);
		timer = System.currentTimeMillis();
	}
	
	public void tick() 
	{
		setPlayerImage();
	}
	
	public void render(Graphics2D g2d) 
	{
		g2d.drawImage(coinImage, (int)posX, (int)posY, null);
	}
	
	public Rectangle getBounds() 
	{
		return new Rectangle((int) posX , (int) posY, 100, 100);
	}
	
	public void setPlayerImage()
	{
		if(System.currentTimeMillis() % timer > 100)
		{
			if(iterator <= 10)
			{
				coinImage = coinSheet.grabImage(iterator,1);
				iterator ++;
				timer = System.currentTimeMillis();
			}
			else
			{
				iterator =1;
			}
		}
	}
}
