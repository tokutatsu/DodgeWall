package scene;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import config.RecordConfig;
import config.WindowConfig;

public class Record extends JPanel implements ActionListener {

	private JButton titleButton;
	private JButton exitButton;
	private Screen screen;

	public Record(Screen screen) {
		setLayout(null);
		this.screen = screen;

		// titleボタン
		titleButton = new JButton("Title");
		titleButton.addActionListener(this);
		titleButton.setBounds(RecordConfig.titleButtonPoint.x, RecordConfig.titleButtonPoint.y, RecordConfig.titleButtonWidth, RecordConfig.titleButtonHeight);
		this.add(titleButton);
		// exitボタン
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		exitButton.setBounds(RecordConfig.exitButtonPoint.x, RecordConfig.exitButtonPoint.y, RecordConfig.exitButtonWidth, RecordConfig.exitButtonHeight);
		this.add(exitButton);
	}

	public void actionPerformed(ActionEvent e){
		switch ( e.getActionCommand() ) {
		case "title":
			screen.changeJPanel(new Title(screen));
			break;
		case "exit":
			System.exit(0);
			break;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		String head = new String("Ranking");
		String score = new String("1. 12345");

		// headの表示
		g.setColor(RecordConfig.headColor);
		g.setFont(RecordConfig.headFont);
		FontMetrics headFontMetrics = g.getFontMetrics();
		g.drawString(head, (WindowConfig.Width-headFontMetrics.stringWidth(head)-headFontMetrics.charWidth('l'))/2, RecordConfig.headY);

		// ランキングの表示
		g.setColor(RecordConfig.recordColor);
		g.setFont(RecordConfig.recordFont);
		FontMetrics recordFontMetrics = g.getFontMetrics();
		for ( int i = 0; i < 10; i++ ) {
			g.drawString(score, (WindowConfig.Width-recordFontMetrics.stringWidth(score)-recordFontMetrics.charWidth('l'))/2, RecordConfig.recordY+i*(recordFontMetrics.getHeight()+10));
		}
	}

}
