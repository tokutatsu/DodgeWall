package unit;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Wall extends Unit {

	private final int height = 1;
	private Color color = new Color(255, 0, 255, 0);
	private Polygon wall;
	private String name;

	public void Wall(String name) {
		this.name = name;
	}

	@Override
	void draw(Graphics g) {
		g.setColor(color);
		g.fillPolygon(wall);
		g.setColor(new Color(0, 0, 0));
		g.drawPolygon(wall);
	}

}
