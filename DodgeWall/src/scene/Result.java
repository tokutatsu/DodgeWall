package scene;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import config.ResultConfig;
import config.WindowConfig;
import process.Ranking;

public class Result extends JPanel implements ActionListener {

	private int score;
	private FontMetrics fontMetrics;
	private String userName;
	private String scoreMessage;
	private JTextField inputUserName;
	private JButton titleButton;
	private JButton retryButton;
	private JButton rankingButton;
	private JButton exitButton;
	private Screen screen;

	public Result(int score, Screen screen) {
		setLayout(null);
		this.userName = "Guest";
		this.score = score;
		this.screen = screen;

		// scoreの表示文
		scoreMessage = "SCORE: " + this.score;

		// ユーザ名入力用のTextField
		inputUserName = new JTextField(userName);
		inputUserName.setBounds(ResultConfig.inputUserNamePoint.x, ResultConfig.inputUserNamePoint.y, ResultConfig.inputUserNameWidth, ResultConfig.inputUserNameHeight);
		this.add(inputUserName);

		// titleボタン
		titleButton = new JButton("Title");
		titleButton.addActionListener(this);
		titleButton.setBounds(WindowConfig.titleButtonPoint.x, WindowConfig.titleButtonPoint.y, WindowConfig.titleButtonWidth, WindowConfig.titleButtonHeight);
		this.add(titleButton);

		// retryボタン
		retryButton = new JButton("Retry");
		retryButton.addActionListener(this);
		retryButton.setBounds(WindowConfig.leftButtonPoint.x, WindowConfig.leftButtonPoint.y, WindowConfig.buttonWidth, WindowConfig.buttonHeight);
		this.add(retryButton);

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

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// scoreMessageの描画
		g.setColor(WindowConfig.headColor);
		g.setFont(WindowConfig.headFont);
		fontMetrics = g.getFontMetrics();
		g.drawString(scoreMessage, (WindowConfig.Width-fontMetrics.stringWidth(scoreMessage)-fontMetrics.charWidth('l'))/2, WindowConfig.headY);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		userName = inputUserName.getText();
		switch ( e.getActionCommand() ) {
		case "Title":
			try {
				Ranking.updateRanking(userName, score);
			} catch ( Exception e1 ) { }
			screen.changeJPanel(new Title(screen));
			break;
		case "Retry":
			try {
				Ranking.updateRanking(userName, score);
			} catch ( Exception e1 ) { }
			screen.changeJPanel(new Play(screen));
			break;
		case "Ranking":
			try {
				Ranking.updateRanking(userName, score);
			} catch ( Exception e1 ) { }
			screen.changeJPanel(new Record(screen));
			break;
		case "Exit":
			try {
				Ranking.updateRanking(userName, score);
			} catch ( Exception e1 ) { }
			System.exit(0);
		}

	}
}
