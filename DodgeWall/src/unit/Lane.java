package unit;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Lane extends Unit {
	private Polygon lane;
	private Color color;
	private String name;

	// コンストラクタ
	public Lane(String name) {
		this.name = name;
	}

	// レーンの座標(ポリゴン)を取得
	public Polygon getPolygon() {
		return lane;
	}

	@Override
	void draw(Graphics g) {
		g.setColor(color);
		g.fillPolygon(lane);
	}
}
