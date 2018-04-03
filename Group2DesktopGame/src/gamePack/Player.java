package gamePack;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
//import java.awt.image.BufferedImage;

public class Player extends GameObject{
	
//	private BufferedImageLoader loader;
//	private BufferedImage ss;
//	private BufferedImage playerImage;
//	private SpriteSheet playerSheet;
	private Handler handler;
	
	public boolean gameStart = true;
	public long timer;
	public int iterator = 0;
	
	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		//loader = new BufferedImageLoader();
		//ss = loader.loadImage("");
		//playerImage = loader.loadImage("");
		//playerSheet= new SpriteSheet(ss, 1, 1);
		
		this.handler = handler;
		timer = System.currentTimeMillis();
	}

	public void tick() 
	{
		posX += velX;
		posY += velY;
		
		posX = Clamp.clamp(posX, 0 , 1200);
		posY= Clamp.clamp(posY, 0, 750);
		
		collision();
		//setPlayerImage();
	}
	
	public void render(Graphics2D g2d) 
	{		
		g2d.setColor(Color.green);
		g2d.draw(getBounds());
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillRect((int)posX + 1,(int)posY + 1,149,249);
		
		//g2d.drawImage(playerImage, (int)posX, (int)posY, null);
	}

	public Rectangle getBounds() 
	{
		return new Rectangle((int)posX ,(int)posY,150,250);
	}
	
	public void setPlayerImage()
	{ 
		/*
		if(gameStart == true)
		{
			playerImage = playerSheet.grabImage(1,1);
			gameStart = false;
		}
		if(System.currentTimeMillis() % timer > 250)
		{
			if(iterator == 0)
			{
				playerImage = playerSheet.grabImage(1,1);
				iterator ++;
			}
			else if(iterator == 1)
			{
				playerImage = playerSheet.grabImage(1,1);
				iterator--;
			}
			timer = System.currentTimeMillis();
		}
		*/
	}
	
	public void collision()
	{
		for(int i=0; i< Handler.object.size();  i++)
		{
			GameObject temp = Handler.object.get(i);
			
			if(temp.getId() == ID.Coin)
			{
				if(getBounds().intersects(temp.getBounds()))
				{
					handler.removeObject(temp);
					HUD.score++;
				}
			}
		}
	}
}
