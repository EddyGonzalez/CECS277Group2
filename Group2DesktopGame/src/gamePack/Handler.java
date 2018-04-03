package gamePack;

import java.awt.Graphics2D;
import java.util.LinkedList;

public class Handler {

	static LinkedList<GameObject> object = new LinkedList<GameObject>();

	public void tick()
	{
		for(int i =0; i< object.size(); i++)
		{
			GameObject temp = object.get(i);
			temp.tick();
		}
	}
	
	public void render(Graphics2D g2d)
	{
		for(int i =0; i< object.size(); i++)
		{
			GameObject temp = object.get(i);
			temp.render(g2d);
		}
	}
	
	public void addObject(GameObject obj)
	{
		object.add(obj);
	}
	
	public void removeObject(GameObject obj)
	{
		object.remove(obj);
	}
	
	public static int getObjCount()
	{
		return object.size();
	}
	
	public void clearObjects()
	{
		
	}
	
	public void clearEnemies()
	{
		
	}
}
