package scene;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JPanel;

import config.RecordConfig;
import config.WindowConfig;
import process.Ranking;

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
		case "Title":
			screen.changeJPanel(new Title(screen));
			break;
		case "Exit":
			System.exit(0);
			break;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		String head = new String("Ranking");
		ArrayList<HashMap<String, String>> recordList = new ArrayList<HashMap<String, String>>();
		try {
			recordList = Ranking.getTopTenRanking();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// headの表示
		g.setColor(RecordConfig.headColor);
		g.setFont(RecordConfig.headFont);
		FontMetrics headFontMetrics = g.getFontMetrics();
		g.drawString(head, (WindowConfig.Width-headFontMetrics.stringWidth(head)-headFontMetrics.charWidth('l'))/2, RecordConfig.headY);

		// ランキングの表示
		g.setColor(RecordConfig.recordColor);
		g.setFont(RecordConfig.recordFont);
		FontMetrics recordFontMetrics = g.getFontMetrics();
		for ( int i = 0; i < recordList.size(); i++ ) {
			String record = Integer.toString(i+1) + ". " + recordList.get(i).get("userName") + " " + recordList.get(i).get("score");
			g.drawString(Integer.toString(i+1), RecordConfig.rankX-Integer.toString(i+1).length() * g.getFontMetrics().charWidth('1'), RecordConfig.recordY+i*(recordFontMetrics.getHeight()+10));
			g.drawString(". ", RecordConfig.userNameX-g.getFontMetrics().stringWidth(". "), RecordConfig.recordY+i*(recordFontMetrics.getHeight()+10));
			g.drawString(recordList.get(i).get("userName"), RecordConfig.userNameX, RecordConfig.recordY+i*(recordFontMetrics.getHeight()+10));
			g.drawString(" ", RecordConfig.scoreX-g.getFontMetrics().charWidth(' '), RecordConfig.recordY+i*(recordFontMetrics.getHeight()+10));
			g.drawString(recordList.get(i).get("score"), RecordConfig.scoreX - recordList.get(i).get("score").length() * g.getFontMetrics().charWidth('1'), RecordConfig.recordY+i*(recordFontMetrics.getHeight()+10));
		}
	}

}