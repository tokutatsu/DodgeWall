package unit;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Wall extends Unit {

	private final int height = 1;
	private Color color = new Color(255, 0, 255, 0);
	private Point points[] = new Point[4];
	private String name;

	public void Wall(int displayHeight, String name) {
		this.name = name;
	}

	@Override
	void draw(Graphics g) {
		// TODO 自動生成されたメソッド・スタブ
	}

}
