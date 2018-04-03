package gamePack;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class GameObject {
	
	protected float posX, posY;
	protected ID id;
	protected float velX, velY;
	
	public GameObject(float x, float y, ID id)
	{
		this.posX = x;
		this.posY = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics2D g2d);
	public abstract Rectangle getBounds();
	
	public void setX(int x)
	{
		this.posX = x;
	}
	
	public void setY(int y)
	{
		this.posY = y;
	}
	
	public float getX()
	{
		return posX;
	}
	
	public float getY()
	{
		return posY;
	}
	
	public void setId(ID id)
	{
		this.id = id;
	}
	
	public ID getId()
	{
		return id;
	}
	
	public void setVelocityX(int velX)
	{
		this.velX = velX;
	}
	
	public void setVelocityY(int velY)
	{
		this.velY = velY;
	}
	
	public float getVelocityX() 
	{
		return velX;
	}
	
	public float getVelocityY()
	{
		return velY;
	}

}
