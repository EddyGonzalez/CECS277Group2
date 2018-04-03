package gamePack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class HUD {
	
	public static float HEALTH;
	public int bounds;
	public static float greenValue;
	public static float redValue;
	
	public static int score;
	private int level;
	
	public HUD()
	{
		HEALTH = 100;
		bounds =0;
		greenValue = 255;
		redValue = 50;
		score = 0;
		level = 1;
	}
	
	public void tick()
	{
		HEALTH = Clamp.clamp(HEALTH, 0 , 100);
		greenValue = Clamp.clamp(greenValue, 0, 255);
		redValue = Clamp.clamp(redValue, 0, 255);
	}
	
	public void render(Graphics2D g)
	{
		g.setColor(Color.gray);
		g.fillRect(15, 15, 400 + bounds, 45);
		g.setColor(new Color((int)redValue,(int)greenValue,30));
		g.fillRect(15, 15, (int) HEALTH*4, 45);
		g.setColor(Color.black);
		g.drawRect(15, 15, 400 + bounds, 45);
		
		g.setColor(Color.RED);
		g.fillRect(20, 10, 7, 19);
		g.fillRect(14, 15, 19, 7);

		g.setColor(Color.black);
		g.fillRect( 985, 5, 200, 45);
		g.drawString("Object Count: " + Handler.getObjCount(), 1100, 60);
		
		g.setColor(Color.white);
		g.setFont(new Font("Comic Sans",1,20));
		g.drawString("Score:" + score, 1100, 30);
		g.drawString("Level:" + level, 1000, 30);
	}
}
