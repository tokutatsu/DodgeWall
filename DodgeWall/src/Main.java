import javax.swing.SwingUtilities;

import scene.Screen;
import scene.Title;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Screen screen = new Screen();
			screen.changeJPanel(new Title());
		});
	}
}