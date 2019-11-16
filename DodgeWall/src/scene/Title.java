package scene;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import config.TitleConfig;
import config.WindowConfig;

public class Title extends JPanel implements ActionListener {


	private static JTextField textField;
	private static JButton addButton;
	private static JButton startButton;
	private static JButton rankingButton;
	private static JButton exitButton;
	private static String username;

	public Title(String userName) {
		setLayout(null);
		textField = new JTextField(userName);
		username = textField.getText();

		// テキスト
		textField.setBounds(TitleConfig.textFieldX, TitleConfig.textFieldY, TitleConfig.textFieldWidth, TitleConfig.textFieldHeight);
		this.add(textField);
		// addボタン
		addButton = new JButton("add");
		addButton.addActionListener(this);
		addButton.setBounds(TitleConfig.addButtonX, TitleConfig.addButtonY, TitleConfig.addButtonWidth, TitleConfig.addButtonHeight);
		this.add(addButton);
		// startボタン
		startButton = new JButton("start");
		startButton.addActionListener(this);
		startButton.setBounds(TitleConfig.startButtonX, TitleConfig.startButtonY, TitleConfig.startButtonWidth, TitleConfig.startButtonHeight);
		this.add(startButton);
		// rankingボタン
		rankingButton = new JButton("ranaking");
		rankingButton.addActionListener(this);
		rankingButton.setBounds(TitleConfig.rankingButtonX, TitleConfig.rankingButtonY, TitleConfig.rankingButtonWidth, TitleConfig.rankingButtonHeight);
		this.add(rankingButton);
		// exitボタン
		exitButton = new JButton("exit");
		exitButton.addActionListener(this);
		exitButton.setBounds(TitleConfig.exitButtonX, TitleConfig.exitButtonY, TitleConfig.exitButtonWidth, TitleConfig.exitButtonHeight);
		this.add(exitButton);
	}

	public void actionPerformed(ActionEvent e){
		switch ( e.getActionCommand() ) {
		case "add":{
			username = textField.getText();
			repaint();
			break;
		}
		case "start": {
			Play play = new Play();
			add(play);
			break;
		}
		case "ranking": {
			break;
		}
		case "exit": {
			System.exit(0);
			break;
		}
		}
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		// title
		g.setColor(TitleConfig.titleColor);
		g.setFont(TitleConfig.titleFont);
		g.drawString(TitleConfig.titleName, WindowConfig.Width/2-g.getFontMetrics().stringWidth(TitleConfig.titleName)/2, TitleConfig.titleY);
		// username
		if ( !username.equals(TitleConfig.usernameInit) ) {
			g.setColor(TitleConfig.usernameColor);
			g.setFont(TitleConfig.usernameFont);
			g.drawString(username, WindowConfig.Width/2-g.getFontMetrics().stringWidth(username)/2, TitleConfig.usernameY);
		}
	}

}
