package unit;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Background extends Unit {

	private Color color = new Color(0, 0, 100, 0);
	private Point points[] = new Point[3];
	private String name;

	public void Background(int displayHeight, String name) {
		this.name = name;
	}

	@Override
	public void draw(Graphics g) {

	}

}
