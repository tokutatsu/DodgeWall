package scene;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import config.ResultConfig;
import config.WindowConfig;

public class Result extends JPanel implements ActionListener {

	private int score;
	private static int scoreMessageLength;
	private String userName;
	private static String scoreMessage;
	private static JTextField inputUserName;
	private static JButton titleButton;
	private static JButton retryButton;
	private static JButton rankingButton;
	private static JButton exitButton;

	public Result(int score) {
		setLayout(null);
		this.userName = "Guest Name";
		this.score = score;

		// scoreの表示文
		scoreMessage = "Score: " + this.score;

		// ユーザ名入力用のTextField
		inputUserName = new JTextField(userName);
		inputUserName.setBounds(ResultConfig.inputUserNamePoint.x, ResultConfig.inputUserNamePoint.y, ResultConfig.inputUserNameWidth, ResultConfig.inputUserNameHeight);
		this.add(inputUserName);

		// titleボタン
		titleButton = new JButton("Title");
		titleButton.addActionListener(this);
		titleButton.setBounds(ResultConfig.titleButtonPoint.x, ResultConfig.titleButtonPoint.y, ResultConfig.titleButtonWidth, ResultConfig.titleButtonHeight);
		this.add(titleButton);

		// retryボタン
		retryButton = new JButton("Retry");
		retryButton.addActionListener(this);
		retryButton.setBounds(ResultConfig.retryButtonPoint.x, ResultConfig.retryButtonPoint.y, ResultConfig.retryButtonWidth, ResultConfig.retryButtonHeight);
		this.add(retryButton);

		// rankingボタン
		rankingButton = new JButton("Ranking");
		rankingButton.addActionListener(this);
		rankingButton.setBounds(ResultConfig.rankingButtonPoint.x, ResultConfig.rankingButtonPoint.y, ResultConfig.rankingButtonWidth, ResultConfig.rankingButtonHeight);
		this.add(rankingButton);

		// exitボタン
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		exitButton.setBounds(ResultConfig.exitButtonPoint.x, ResultConfig.exitButtonPoint.y, ResultConfig.exitButtonWidth, ResultConfig.exitButtonHeight);
		this.add(exitButton);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// scoreMessageの描画
		g.setColor(ResultConfig.fontColor);
		g.setFont(ResultConfig.scoreFont);
		scoreMessageLength = g.getFontMetrics().stringWidth(scoreMessage);
		g.drawString(scoreMessage, WindowConfig.Width/2-scoreMessageLength/2, ResultConfig.scoreY);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}
}
