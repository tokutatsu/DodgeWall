import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class Wall extends JPanel {

	private int height = 1;
	private Color color = new Color(255, 0, 255, 0);
	private Point points[] = new Point[4];
	private String name = new String();

	public void Wall(int displayHeight, String name) {
		this.name = name;
	}

	@Override
	public void paintComponent(Graphics g) {
	}


}
