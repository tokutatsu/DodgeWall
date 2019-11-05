import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class Lane extends JPanel {
	private Point[] lanePoint;
	private Color laneColor;
	private Color laneBorderColor;
	private String laneName;
	private int laneBorderWidth;

	public Lane(int windowHeight, String ballName) {

	}

	public Point[] getPoint() {
		return lanePoint;
	}

	@Override
	public void paintComponent(Graphics g) {

	}
}
