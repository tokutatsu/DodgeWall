package unit;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Background extends Unit {

	private Color color = new Color(0, 0, 100, 0);
	private Polygon background;
	private String name;

	public void Background(String name) {
		this.name = name;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillPolygon(background);
	}
}
