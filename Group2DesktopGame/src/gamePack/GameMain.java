package gamePack;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
	
public class GameMain extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	private Thread thread;
	private HUD hud;
	private Handler handler;
	private KeyInput key;
	private BufferedImageLoader loader;
	private BufferedImage backdrop;
	
	public static final int WIDTH = 1350;
	public static final int HEIGHT = WIDTH/12 * 9;
	public static final int SCALE = 3;
	public static final String NAME= "Orion";
	public int tickCount=0;
	public boolean running = false;
	
	public GameMain()
	{
		handler = new Handler();
		hud = new HUD();
		loader = new BufferedImageLoader();
		backdrop = loader.loadImage("/TutorialLevelBackground.jpg");
		
		new GameWindow(WIDTH,HEIGHT,NAME,this);
		
		handler.addObject(new Player(600, 650, ID.Player, handler));
		key = new KeyInput(handler);
		this.addKeyListener(key);
		
		handler.addObject(new Coin( 150, 400, ID.Coin));
		handler.addObject(new Coin( 450, 400, ID.Coin));
		handler.addObject(new Coin( 750, 400, ID.Coin));
		handler.addObject(new Coin( 1050, 400, ID.Coin));
		
		handler.addObject(new Target(0,100, ID.Target, handler));
		handler.addObject(new Target(150,100, ID.Target, handler));

		handler.addObject(new Target(450,100, ID.Target, handler));
		handler.addObject(new Target(600,100, ID.Target, handler));

		handler.addObject(new Target(900,100, ID.Target, handler));
		handler.addObject(new Target(1050,100, ID.Target, handler));
		handler.addObject(new Target(1200,100, ID.Target, handler));

	}
	
	public synchronized void start()
	{
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop()
	{
		try 
		{
			thread.join();
			running = false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void run() 
	{
		this.requestFocus();
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D/60D;
		
		int ticks = 0;
		int frames = 0;
		
		long lastTimer = System.currentTimeMillis();
		double delta = 0;
		while(running)
		{
			long now = System.nanoTime();
			delta+=(now-lastTime) / nsPerTick;
			lastTime = now;
			
			boolean shouldRender = true;
			
			while(delta >= 1)
			{
				ticks++;
				tick();
				delta -= 2;
				shouldRender=true;
			}
			
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(shouldRender)
			{
				frames++;
				render();
			}
			
			if(System.currentTimeMillis() - lastTimer >= 1000)
			{
				lastTimer += 1000;
				System.out.println(frames+" frames ,"+ticks + " ticks");
				frames=0;
				ticks=0;
			}
		}
	}
	
	public void tick()
	{
		handler.tick();
		hud.tick();
		tickCount++;
	}
	
	public void render()
	{
		BufferStrategy bs = getBufferStrategy();
		if(bs==null)
		{
			createBufferStrategy(3);
			return;
		}
		
		Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();
		
		g2d.setColor(null);
		g2d.drawImage(backdrop,0,0,null);
		
		//This is where you put all characters and stuff
		handler.render(g2d);
		hud.render(g2d);
		
		g2d.dispose();
		bs.show();
	}
	
	//Remove Later and construct in main File
	
	public static void main(String[] args)
	{
		new GameMain();
	}	
	
}
