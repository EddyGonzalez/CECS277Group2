package guiPack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MainMenu{
	
	private Color green = new Color(69, 179, 157);
	private JPanel container;
	private JPanel cardContainer;
	private BufferedImage image;
	private Image buttonImage;
	private JLabel imageLabel;
	private ActionListener listener;
	private JButton startButton;
	private JButton helpButton;
	private JButton settingsButton;
	private GUI parent;
	
	public MainMenu(JPanel cardContainer, GUI window)
	{
		
		parent = window;
		container = new JPanel();
		this.cardContainer = cardContainer;
		container.setLayout(null);
		container.setOpaque(false);
		
		//Create Buttons
		startButton = new JButton("Start Game");
		helpButton = new JButton("Help");
		settingsButton = new JButton("Settings");
		
		//Set Name
		startButton.setName("Start");
		helpButton.setName("Help Menu");
		settingsButton.setName("Settings");
		
		//Set Color
		startButton.setBackground(green);
		helpButton.setBackground(green);
		settingsButton.setBackground(green);
		
		//Set Bounds
		startButton.setBounds(100, 700, 200, 50);
		helpButton.setBounds(100, 770, 200, 50);
		settingsButton.setBounds(100, 840, 200, 50);
		
		//Set Font
		startButton.setFont(new Font("Arial", Font.BOLD, 30));
		helpButton.setFont(new Font("Arial", Font.BOLD, 30));
		settingsButton.setFont(new Font("Arial", Font.BOLD, 30));
		
		//Image Try Catch
		try 
		{
			image = ImageIO.read( new File("res/FrontGameLogo_50.jpg"));
			buttonImage = ImageIO.read( new File("res/brushStroke.png"));
			buttonImage = buttonImage.getScaledInstance(200, 50, java.awt.Image.SCALE_SMOOTH);
//			startButton.setIcon(new ImageIcon(buttonImage));
//			helpButton.setIcon(new ImageIcon(buttonImage));
//			settingsButton.setIcon(new ImageIcon(buttonImage));

		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}

		//Image
		imageLabel = new JLabel(new ImageIcon(image));
		imageLabel.setLayout(null);
		imageLabel.setBounds(window.getLocationX() - (1080/2), window.getLocationY() - (1080/2), 1080, 1080);
		imageLabel.setName("Pic");
		
		listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				if (e.getSource() == startButton) {
					parent.changePage(1);
					
				}
				
				else if (e.getSource() == helpButton) {
					parent.changePage(2);

				}
				
				else if (e.getSource() == settingsButton) {
					parent.changePage(3);
					
				}
			}
		};
		
		startButton.addActionListener(listener);
		helpButton.addActionListener(listener);
		settingsButton.addActionListener(listener);
		
		container.add(startButton);
		container.add(helpButton);
		container.add(settingsButton);
		container.add(imageLabel);

	}
	
	public JPanel getContainer()
	{
		return container;
	}
		
		
}