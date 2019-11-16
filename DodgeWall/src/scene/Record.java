package scene;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import config.RecordConfig;
import config.WindowConfig;

public class Record extends JPanel implements ActionListener {

	private static JButton titleButton;
	private static JButton exitButton;

	public Record() {
		setLayout(null);

		// titleボタン
		titleButton = new JButton("title");
		titleButton.addActionListener(this);
		titleButton.setBounds(RecordConfig.titleButtonPoint.x, RecordConfig.titleButtonPoint.y, RecordConfig.titleButtonWidth, RecordConfig.titleButtonHeight);
		this.add(titleButton);
		// exitボタン
		exitButton = new JButton("exit");
		exitButton.addActionListener(this);
		exitButton.setBounds(RecordConfig.exitButtonPoint.x, RecordConfig.exitButtonPoint.y, RecordConfig.exitButtonWidth, RecordConfig.exitButtonHeight);
		this.add(exitButton);
	}

	public void actionPerformed(ActionEvent e){
		switch ( e.getActionCommand() ) {
		case "title":
			break;
		case "exit":
			System.exit(0);
			break;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		String score = new String("1. 12345");
		// title
		g.setColor(RecordConfig.rankingColor);
		g.setFont(RecordConfig.rankingFont);
		for ( int i = 0; i < 0; i++ ) {
			g.drawString(score, (WindowConfig.Width-g.getFontMetrics().stringWidth(score)-g.getFontMetrics().charWidth('l'))/2, RecordConfig.rankingY);
		}
	}

}
