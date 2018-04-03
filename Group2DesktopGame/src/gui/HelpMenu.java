package guiPack;

import java.awt.Color;
import java.awt.Font;
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

public class HelpMenu{
		
	private ActionListener listener;
	private Color green = new Color(69, 179, 157);
	private JPanel container;
	private JPanel cardContainer;
	private BufferedImage image;
	private int tutorialPage = 1;
	private JLabel imageLabel;
	private JButton backButton;
	private JButton leftButton;
	private JButton rightButton;
	
	private GUI parent;
	
	public HelpMenu(JPanel cardContainer, GUI window)
	{
		parent = window;
		container = new JPanel();
		this.cardContainer = cardContainer;
		container.setLayout(null);
		container.setOpaque(false);
		
		//Create Buttons
		backButton = new JButton("Back");
		leftButton = new JButton("Previous Lesson");
		rightButton = new JButton ("Next Lesson");
		
		//Set Names
		backButton.setName("Back Button");
		leftButton.setName("Left Button");
		rightButton.setName("Right Button");
		
		//Set Color
		backButton.setBackground(green);
		leftButton.setBackground(green);
		rightButton.setBackground(green);
		
		//Set Bounds
		backButton.setBounds(100,  60,  85,  40);
		leftButton.setBounds(500, 725,  200,  35);
		rightButton.setBounds(750,  725,  200,  35);
		
		//Set Fonts
		backButton.setFont(new Font("Arial", Font.ITALIC, 20));
		leftButton.setFont(new Font("Arial", Font.ITALIC, 20));
		rightButton.setFont(new Font("Arial", Font.ITALIC, 20));
		
		
			
		//Image Try Catch
		try 
		{
			image = ImageIO.read( new File("res/Tutorial1.jpg"));
			
			//Image
			imageLabel = new JLabel(new ImageIcon(image));
			imageLabel.setLayout(null);
			imageLabel.setBounds(300, 75, 809, 635);
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
		
		listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//Back Button Functionality
				if (e.getSource() == backButton) {
					parent.changePage(0);
					
				}
				
				//Left Button Functionality
				if (e.getSource() == leftButton) {
					
					if (tutorialPage == 2) {
						
						imageLabel.setVisible(false);
						
						try {
							image = ImageIO.read( new File("res/Tutorial1.jpg"));
							imageLabel = new JLabel(new ImageIcon(image));
							imageLabel.setLayout(null);
							imageLabel.setBounds(300, 75, 809, 635);
							imageLabel.setName("Pic");						
							container.add(imageLabel);
						} 
						
						catch (IOException e1) {
							e1.printStackTrace();
						}	
					}
					
					else if (tutorialPage == 3) {
						
						imageLabel.setVisible(false);
						
						try {
							image = ImageIO.read( new File("res/Tutorial2.jpg"));
							imageLabel = new JLabel(new ImageIcon(image));
							imageLabel.setLayout(null);
							imageLabel.setBounds(300, 75, 809, 635);
							imageLabel.setName("Pic");						
							container.add(imageLabel);
						} 
						
						catch (IOException e1) {
							e1.printStackTrace();
						}	
					}
					tutorialPage --;
				}
					
				//Right Button Functionality
				if (e.getSource() == rightButton) {
					
					if (tutorialPage == 1) {
						
						imageLabel.setVisible(false);
						
						try {
							image = ImageIO.read( new File("res/Tutorial2.jpg"));
							imageLabel = new JLabel(new ImageIcon(image));
							imageLabel.setLayout(null);
							imageLabel.setBounds(300, 75, 809, 635);
							imageLabel.setName("Pic");						
							container.add(imageLabel);
						} 
						
						catch (IOException e1) {
							e1.printStackTrace();
						}	
						
						
					}
					
					if (tutorialPage == 2) {
							
						imageLabel.setVisible(false);
						
						try {
							image = ImageIO.read( new File("res/Tutorial3.jpg"));
							imageLabel = new JLabel(new ImageIcon(image));
							imageLabel.setLayout(null);
							imageLabel.setBounds(300, 75, 809, 635);
							imageLabel.setName("Pic");	
							container.add(imageLabel);
						} 
						
						catch (IOException e1) {
							e1.printStackTrace();
						}	
							
					}	
					tutorialPage ++;
					
				}

			}
		};
		
		//Add Listeners to Buttons
		backButton.addActionListener(listener);
		leftButton.addActionListener(listener);
		rightButton.addActionListener(listener);
		
		//Add Components to Container
		container.add(backButton);
		container.add(imageLabel);
		container.add(leftButton);
		container.add(rightButton);
	}
	
	public JPanel getContainer()
	{
		return container;
	}
		
}