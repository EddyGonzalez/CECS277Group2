package gamePack;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class GameWindow extends Canvas{
	
	private static final long serialVersionUID = -5320598087147033482L;
	
	public GameWindow(int width, int height, String title, GameMain game)
	{
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width,height));
		frame.setMaximumSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(width,height));
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
}
