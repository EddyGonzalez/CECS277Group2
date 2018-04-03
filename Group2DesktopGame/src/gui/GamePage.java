package guiPack;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GamePage{
	
	private JPanel cardContainer;
	private JPanel container;
	private ActionListener listener;
	private Color green = new Color(69, 179, 157);
//	private JLabel imageLabel;
//	private BufferedImage image;
	private JButton backButton;
	private GUI parent;
	
	public GamePage(JPanel cardContainer, GUI window)
	{
		parent = window;
		container = new JPanel();
		this.cardContainer = cardContainer;
		container.setLayout(null);
		container.setOpaque(false);
				
		//Create Buttons
		backButton = new JButton("Back");
		
		//Set Names
		backButton.setName("Back Button");
		
		//Set Color
		backButton.setBackground(green);
		
		//Set Bounds;
		backButton.setBounds(100, 60, 85, 40);
		
		//Set Fonts
		backButton.setFont(new Font("Arial", Font.ITALIC, 20));
		
		listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				//Button Functionality
				if (e.getSource() == backButton) {
					parent.changePage(0);
					
				}
			}
		};		
		//Add Listeners to Buttons
		backButton.addActionListener(listener);
		
		//Add Components to Container
		container.add(backButton);
		
		//Image Try Catch
		/*
		try 
		{
			image = ImageIO.read( new File("res/Placeholder.png"));
					
			//Image
			imageLabel = new JLabel(new ImageIcon(image));
			imageLabel.setLayout(null);
			imageLabel.setBounds(300, 75, 1000, 800);
			imageLabel.setName("Pic");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
		*/		
	}
	
	public JPanel getContainer()
	{
		return container;
	}	
	
		
}