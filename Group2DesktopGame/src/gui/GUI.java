package guiPack;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
	
public class GUI {
	
	protected JFrame mainWindow;
	private gamePack.GameMain orionGame;
	protected JPanel cardContainer;
	protected MainMenu menu;
	protected HelpMenu help;
	protected GamePage game;
	protected SettingsMenu settings;
	protected CardLayout layout;
	
	final static String MAINPANEL = "Main Menu Panel";
	final static String HELPPANEL = "Help Menu Panel";
	final static String SETTINGSPANEL = "Settings Menu Panel";
	final static String GAMEPANEL = "Game Menu Panel";
	
	private Color white = new Color(255, 255, 255);
	
	public static void main(String[] arg)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try
				{
					GUI window = new GUI();
					window.initialize();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
		});
	}
	
	//Constructor
	public GUI()
	{
		
	}
	
	public void initialize()
	{
		
		//Set-Up Window
		mainWindow = new JFrame();
		mainWindow.setMinimumSize(new Dimension(1500, 1000));
		mainWindow.setPreferredSize(new Dimension(1500, 1000));
		mainWindow.setMaximumSize(new Dimension(1500, 1000));
		mainWindow.setResizable(false);
		mainWindow.setLayout(null);
		mainWindow.setTitle("Rampage: The Game");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);
		mainWindow.setBackground(white);
		mainWindow.setLocationRelativeTo(null);
		
		//Create Main Menu
		cardContainer = new JPanel(new CardLayout());
		cardContainer.setOpaque(false);
		layout = (CardLayout) cardContainer.getLayout();
		
		menu = new MainMenu(cardContainer, this);
		settings = new SettingsMenu(cardContainer, this);
		help = new HelpMenu(cardContainer,this);
		game = new GamePage(cardContainer,this);
		
		cardContainer.add(menu.getContainer(), MAINPANEL);
		cardContainer.add(help.getContainer(), HELPPANEL);
		cardContainer.add(settings.getContainer(), SETTINGSPANEL);
		cardContainer.add(game.getContainer(), GAMEPANEL);

		layout.show(cardContainer, MAINPANEL);

		cardContainer.setBounds(getLocationX(), getLocationY(), 450, 350);
		
		mainWindow.setContentPane(cardContainer);
	}
	
	public int getLocationX()
	{
		return mainWindow.getWidth()/2;
	}
	
	public int getLocationY()

	{
		return mainWindow.getHeight()/2;
	}

	public void actionPerformed(ActionEvent e)
	{
		/*
		switch(e.getActionCommand())
		{
		case "Help":
		{
			JOptionPane.showMessageDialog(null,"Clicked Help Button");
			break;
		}
		case "Start":
		{
			JOptionPane.showMessageDialog(null,"Clicked Start Button");
			break;
		}
		case "Settings":
		{
			JOptionPane.showMessageDialog(null,"Clicked Settings Button");
			break;
		}
		default:
			JOptionPane.showMessageDialog(null,"Something Went Wrong.");
			break;
		}
		*/
	}
	
	public void changePage(int pageNum) 
	{	
		
		int num = cardContainer.getComponentCount();
		
		//hide components
		for (int i = 0; i < num; i++) {
			cardContainer.getComponents()[i].setVisible(false);
		}	
		
		switch (pageNum) {
		case 0:
			//Main Menu Page
			layout.show(cardContainer, MAINPANEL);
			break;
			
		case 1:
			//Game Page	
			layout.show(cardContainer, GAMEPANEL);
			orionGame = new gamePack.GameMain();
			break;
			
		case 2:
			//Help Page
			layout.show(cardContainer, HELPPANEL);
			break;
		
		case 3:
			//Settings Page
			layout.show(cardContainer, SETTINGSPANEL);
			break;
			
		}
	}
}