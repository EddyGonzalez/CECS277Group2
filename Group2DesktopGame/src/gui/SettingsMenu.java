package guiPack;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;

public class SettingsMenu {
	
	private JPanel container;
	private JPanel cardContainer;
	private ActionListener listener;
	private GUI parent;
	private Color cobalt = new Color(0, 71, 171);
	private Color blue = new Color (0, 153, 255);
	private Color lavendar = new Color(194, 182, 249);
	private JButton backButton;
	private JButton settingsButton1;
	private JButton settingsButton2;
	private JButton settingsButton3;
	private JButton settingsButton4;
	private JButton settingsButton5;
	
	//Customize Option Buttons
	private int buttonWidth = 400;
	private int buttonHeight = 100;
	private int menuHeight = 200;
	private int menuWidth;
	private int optionButtonGap = 20;
	private int optionFontSize = 40;
	private Color optionButtonColor = blue;
	
	
	public SettingsMenu(JPanel cardContainer, GUI window)
	{
		parent = window;
		container = new JPanel();
		this.cardContainer = cardContainer;
		container.setLayout(null);
		container.setOpaque(false);
		menuWidth = window.getLocationX() - (buttonWidth/2);
		
		//Create Buttons
		backButton = new JButton("Back");
		settingsButton1 = new JButton("Option");
		settingsButton2 = new JButton("Option");
		settingsButton3 = new JButton("Option");
		settingsButton4 = new JButton("Option");
		settingsButton5 = new JButton("Option");
		
		//Set Names
		backButton.setName("Back Button");
		settingsButton1.setName("Option1");
		settingsButton2.setName("Option2");
		settingsButton3.setName("Option3");
		settingsButton4.setName("Option4");
		settingsButton5.setName("Option5");
		
		//Set Color
		backButton.setBackground(cobalt);
		settingsButton1.setBackground(optionButtonColor);
		settingsButton2.setBackground(optionButtonColor);
		settingsButton3.setBackground(optionButtonColor);
		settingsButton4.setBackground(optionButtonColor);
		settingsButton5.setBackground(optionButtonColor);
		
		//Set Bounds 
		backButton.setBounds(100, 60, 85, 40);
		settingsButton1.setBounds(menuWidth, menuHeight, buttonWidth, 100);
		settingsButton2.setBounds(menuWidth, menuHeight + buttonHeight + optionButtonGap, buttonWidth, buttonHeight);
		settingsButton3.setBounds(menuWidth, menuHeight + (buttonHeight * 2) + (optionButtonGap * 2), buttonWidth, buttonHeight);
		settingsButton4.setBounds(menuWidth, menuHeight + (buttonHeight * 3) + (optionButtonGap * 3), buttonWidth, buttonHeight);
		settingsButton5.setBounds(menuWidth, menuHeight + (buttonHeight * 4) + (optionButtonGap * 4), buttonWidth, buttonHeight);
		
		//Set Fonts
		backButton.setFont(new Font("Arial", Font.ITALIC, 20));
		settingsButton1.setFont(new Font("Arial", Font.BOLD, optionFontSize));
		settingsButton2.setFont(new Font("Arial", Font.BOLD, optionFontSize));
		settingsButton3.setFont(new Font("Arial", Font.BOLD, optionFontSize));
		settingsButton4.setFont(new Font("Arial", Font.BOLD, optionFontSize));
		settingsButton5.setFont(new Font("Arial", Font.BOLD, optionFontSize));
		
		
		listener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				
				//Button Functionality
				if (e.getSource() == backButton) {
					parent.changePage(0);
					
				}
				
				else if (e.getSource() == settingsButton1) {

				}
				
				else if (e.getSource() == settingsButton2) {
					
				} 
				
				else if (e.getSource() == settingsButton3) {
					
				} 
				
				else if (e.getSource() == settingsButton4) {
					
				} 
				
				else if (e.getSource() == settingsButton5) {
					
				} 
			}
			
		};
		
		//Add Listeners to Buttons
		backButton.addActionListener(listener);
		settingsButton1.addActionListener(listener);
		settingsButton2.addActionListener(listener);
		settingsButton3.addActionListener(listener);
		settingsButton4.addActionListener(listener);
		settingsButton5.addActionListener(listener);
		
		//Add Components to Container
		container.add(backButton);
		container.add(settingsButton1);
		container.add(settingsButton2);
		container.add(settingsButton3);
		container.add(settingsButton4);
		container.add(settingsButton5);
		
	}
	
	public JPanel getContainer()
	{
		return container;
	}
	
	public void closeCardContainer() {
		cardContainer.setVisible(false);
	}
		
}