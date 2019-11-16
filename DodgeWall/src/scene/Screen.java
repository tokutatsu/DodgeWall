package scene;

import javax.swing.JFrame;
import javax.swing.JPanel;

import config.WindowConfig;

public class Screen extends JFrame {

	// コンストラクタ
	public Screen() {
		super("DODGE WALL");
		pack();
		setVisible(true);
		setSize(WindowConfig.Width, WindowConfig.Height);
		setLocationRelativeTo(null);
		setFocusable(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//  シーンの移動(JPanelをチェンジする)
	public void changeJPanel(JPanel panel) {
		this.getContentPane().removeAll();
		this.add(panel);
		setVisible(true);
	}
}
