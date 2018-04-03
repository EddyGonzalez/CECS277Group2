package gamePack;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private GameObject player;
	private boolean[] keyDown = new boolean[5];
	
	public KeyInput(Handler handler)
	{
		this.handler = handler;
		
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
		keyDown[4] = false;
		
		for(int i=0; i< Handler.object.size(); i++)
		{
			GameObject temp = Handler.object.get(i);
			
			if(temp.id == ID.Player)
			{
				player = Handler.object.get(i);
				break;
			}
		}
	}
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();

		//all key events for player
		if(key == KeyEvent.VK_W)
		{
			player.setVelocityY(-20);
			keyDown[0] = true;
		}
		else if(key == KeyEvent.VK_S)
		{
			player.setVelocityY(20);
			keyDown[1] = true;
		}
		else if(key == KeyEvent.VK_D)
		{
			player.setVelocityX(25);
			keyDown[2] = true;
		}
		else if(key == KeyEvent.VK_A)
		{
			player.setVelocityX(-25);
			keyDown[3] = true;
		}
		
		if(key ==KeyEvent.VK_SPACE)
		{
			if(keyDown[4] == false)
			{
				handler.addObject(new PlayerBullet(player.getX() + 55, player.getY(), ID.PlayerBullet, handler));
				handler.addObject(new PlayerBullet(player.getX() + 75, player.getY(), ID.PlayerBullet, handler));
				keyDown[4] = true;
			}
		}

	}
	
	public void keyReleased(KeyEvent e) 
	{
		int key = e.getKeyCode();
		
		//all key events for player
		if(key == KeyEvent.VK_W)
		{
			keyDown[0] = false;
		}
		else if(key == KeyEvent.VK_S)
		{
			keyDown[1] = false;
		}
		else if(key == KeyEvent.VK_D)
		{
			keyDown[2] = false;
		}
		else if(key == KeyEvent.VK_A)
		{
			keyDown[3] = false;
		}
		else if(key == KeyEvent.VK_SPACE)
		{
			keyDown[4] = false;
		}
		
		if(!keyDown[0] && !keyDown[1])
		{
			player.setVelocityY(0);
		}
		if(!keyDown[2] && !keyDown[3])
		{
			player.setVelocityX(0);
		}
	}
}
