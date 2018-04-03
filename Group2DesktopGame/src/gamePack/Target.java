package gamePack;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Target extends GameObject{
	
	private BufferedImageLoader loader;
	private BufferedImage targetImage;
	private BufferedImage targetShadow;
	private Handler handler;
	
	public boolean gameStart = true;
	public long timer;
	public int iterator = 1;
	public int subIterator = 1;
	public float targX, targY;
	
	public Target(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		targX =posX;
		targY =posY;
		
		loader = new BufferedImageLoader();
		targetImage = loader.loadImage("/basicBullsEye.png");
		targetShadow = loader.loadImage("/TargetShadow.png");
		timer = System.currentTimeMillis();
	}
	
	public void tick() 
	{
		collision();
		setPlayerImage();
	}
	
	public void render(Graphics2D g2d) 
	{		
		g2d.drawImage(targetShadow, (int)posX+25, (int)posY+125, null);
		g2d.drawImage(targetImage, (int)targX, (int)targY, null);

	}
	
	public Rectangle getBounds() 
	{
		return new Rectangle((int) targX , (int) targY, 150, 150);
	}
	
	public void collision()
	{
		for(int i=0; i< handler.object.size();  i++)
		{
			GameObject temp = handler.object.get(i);

			if(temp.getId() == ID.PlayerBullet)
				if(getBounds().intersects(temp.getBounds()))
				{
					handler.addObject(new Explosion(posX, posY, ID.Explosion, handler));
					handler.removeObject(temp);
					handler.removeObject(this);
				}
		}
	}
	
	public void setPlayerImage()
	{
		if(System.currentTimeMillis() % timer > 75)
		{
			if(iterator == 1)
			{
				targY++;
				subIterator+=1;
				if(subIterator==25)
				{
					subIterator = 1;
					iterator++;
				}
			}
			else
			{
				targY--;
				subIterator+=1;
				if(subIterator==25)
				{
					subIterator = 1;
					iterator--;
				}
			}
			timer = System.currentTimeMillis();

		}
	}
}
