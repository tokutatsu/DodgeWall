import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import scene.Play;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("DodgeWall");
			Play play = new Play();
			frame.add(play);
			frame.pack();
			frame.setVisible(true);
			frame.setSize(500, 1000);
			frame.setLocationRelativeTo(null);
	        frame.setFocusable(true);
	        frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		});
	}
}