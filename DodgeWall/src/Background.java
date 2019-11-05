import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class Background extends JPanel {

	private Color color = new Color(0, 0, 100, 0);
	private Point points[] = new Point[3];
	private String name = new String();

	public void Background(int displayHeight, String name) {
		this.name = name;
	}

	@Override
	public void paintComponent(Graphics g) {
	}

}
