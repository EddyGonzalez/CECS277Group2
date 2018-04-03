package gamePack;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Explosion extends GameObject{
	
	private BufferedImageLoader loader;
	private BufferedImage ss;
	private BufferedImage explosionImage;
	private SpriteSheet explosionSheet;
	private Handler handler;
	
	public boolean gameStart = true;
	public long timer;
	public int iterator = 1;
	
	public Explosion(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		loader = new BufferedImageLoader();
		ss = loader.loadImage("/explosion.png");
		explosionSheet= new SpriteSheet(ss, 128, 128);
		timer = System.currentTimeMillis();
	}
	
	public void tick() 
	{
		setPlayerImage();
	}
	
	public void render(Graphics2D g2d) 
	{
		g2d.drawImage(explosionImage, (int)posX, (int)posY, null);
	}
	
	public Rectangle getBounds() 
	{
		return new Rectangle((int) posX , (int) posY, 100, 100);
	}
	
	public void setPlayerImage()
	{
		if(System.currentTimeMillis() % timer >= 15)
		{
			if(iterator <= 4)
			{
				explosionImage = explosionSheet.grabImage(iterator,1);
				iterator ++;
				timer = System.currentTimeMillis();
			}
			else if(iterator <= 8)
			{
				explosionImage = explosionSheet.grabImage(iterator-4,2);
				iterator ++;
				timer = System.currentTimeMillis();
			}
			else if(iterator <= 12)
			{
				explosionImage = explosionSheet.grabImage(iterator-8,3);
				iterator ++;
				timer = System.currentTimeMillis();
				
			}
			else if(iterator <= 16)
			{
				explosionImage = explosionSheet.grabImage(iterator-12,4);
				iterator ++;
				timer = System.currentTimeMillis();
			}
			else
			{
				handler.removeObject(this);
			}
		}
	}
}
