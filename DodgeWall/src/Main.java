import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import config.WindowConfig;
import scene.Play;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("DodgeWall");
			Play play = new Play();
			frame.add(play);
//			Title title = new Title(TitleConfig.usernameInit);
//			frame.add(title);
			frame.pack();
			frame.setVisible(true);
			frame.setSize(WindowConfig.Width, WindowConfig.Height);
			frame.setLocationRelativeTo(null);
			frame.setFocusable(true);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		});
	}
}