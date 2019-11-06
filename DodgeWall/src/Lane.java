import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class Lane extends JPanel {
	private Point lanePoints[];
	private Color laneColor;
	private Color laneBorderColor;
	private String laneName;
	private int laneBorderWidth;

	// コンストラクタ
	public Lane(int windowHeight, String laneName) {

	}

	// レーンの座標を取得
	public Point[] getPoint() {
		return lanePoints;
	}

	@Override
	public void paintComponent(Graphics g) {

	}
}
