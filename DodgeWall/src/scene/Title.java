package scene;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import config.WindowConfig;

public class Title extends JPanel implements ActionListener {

	private JButton startButton;
	private JButton rankingButton;
	private JButton exitButton;
	private Screen screen;

	public Title(Screen screen) {
		setLayout(null);
		this.screen = screen;

		// startボタン
		startButton = new JButton("Start");
		startButton.addActionListener(this);
		startButton.setBounds(WindowConfig.leftButtonPoint.x, WindowConfig.leftButtonPoint.y, WindowConfig.buttonWidth, WindowConfig.buttonHeight);
		this.add(startButton);
		// rankingボタン
		rankingButton = new JButton("Ranking");
		rankingButton.addActionListener(this);
		rankingButton.setBounds(WindowConfig.rightButtonPoint.x, WindowConfig.rightButtonPoint.y, WindowConfig.buttonWidth, WindowConfig.buttonHeight);
		this.add(rankingButton);
		// exitボタン
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		exitButton.setBounds(WindowConfig.exitButtonPoint.x, WindowConfig.exitButtonPoint.y, WindowConfig.exitButtonWidth, WindowConfig.exitButtonHeight);
		this.add(exitButton);
	}

	public void actionPerformed(ActionEvent e){
		switch ( e.getActionCommand() ) {
		case "Start":
			screen.changeJPanel(new Play(screen));
			break;
		case "Ranking":
			screen.changeJPanel(new Record(screen));
			break;
		case "Exit":
			System.exit(0);
			break;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// title
		String head = "DODGE WALL";
		g.setColor(WindowConfig.headColor);
		g.setFont(WindowConfig.headFont);
		g.drawString(head, (WindowConfig.Width-g.getFontMetrics().stringWidth(head)-g.getFontMetrics().charWidth('l'))/2, WindowConfig.headY);
	}

}
