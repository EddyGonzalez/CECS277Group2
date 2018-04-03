package gamePack;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject{

	private Handler handler;
	private BufferedImageLoader loader;
	private BufferedImage bullet;
	
	public PlayerBullet(float x, float y, ID id, Handler handler) 
	{
		super(x, y, id);
		
		this.handler = handler;
		
		loader = new BufferedImageLoader();
		
		bullet = loader.loadImage("/plasmaBullet.png");
		
		velY = -45;
	}

	public void tick() 
	{
		posX+=velX;
		posY+=velY;
		
		if(posY <= -50)
		{
			handler.removeObject(this);
		}
	}

	public void render(Graphics2D g2d) 
	{
		g2d.setColor(Color.CYAN);
		g2d.drawImage(bullet, (int) posX,(int) posY, null);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) posX, (int) posY, 25,25);
	}
	

}
