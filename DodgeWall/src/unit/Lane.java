package unit;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Lane extends Unit {
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
	void draw(Graphics g) {
		// TODO 自動生成されたメソッド・スタブ

	}
}
