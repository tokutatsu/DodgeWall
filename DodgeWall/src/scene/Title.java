package scene;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import config.TitleConfig;
import config.WindowConfig;

public class Title extends JPanel implements ActionListener {


	private static JButton startButton;
	private static JButton rankingButton;
	private static JButton exitButton;

	public Title() {
		setLayout(null);

		// startボタン
		startButton = new JButton("start");
		startButton.addActionListener(this);
		startButton.setBounds(TitleConfig.startButtonPoint.x, TitleConfig.startButtonPoint.y, TitleConfig.startButtonWidth, TitleConfig.startButtonHeight);
		this.add(startButton);
		// rankingボタン
		rankingButton = new JButton("ranking");
		rankingButton.addActionListener(this);
		rankingButton.setBounds(TitleConfig.rankingButtonPoint.x, TitleConfig.rankingButtonPoint.y, TitleConfig.rankingButtonWidth, TitleConfig.rankingButtonHeight);
		this.add(rankingButton);
		// exitボタン
		exitButton = new JButton("exit");
		exitButton.addActionListener(this);
		exitButton.setBounds(TitleConfig.exitButtonPoint.x, TitleConfig.exitButtonPoint.y, TitleConfig.exitButtonWidth, TitleConfig.exitButtonHeight);
		this.add(exitButton);
	}

	public void actionPerformed(ActionEvent e){
		switch ( e.getActionCommand() ) {
		case "start":
			break;
		case "ranking":
			break;
		case "exit":
			System.exit(0);
			break;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// title
		g.setColor(TitleConfig.titleColor);
		g.setFont(TitleConfig.titleFont);
		g.drawString(TitleConfig.titleName, (WindowConfig.Width-g.getFontMetrics().stringWidth(TitleConfig.titleName)-g.getFontMetrics().charWidth('l'))/2, TitleConfig.titleY);
	}

}
