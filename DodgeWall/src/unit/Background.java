package unit;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import config.BackgroundConfig;

public class Background extends Unit {

	private Color color = BackgroundConfig.color;
	private Polygon background;
	private String name;

	public Background(String name) {
		this.name = name;

		switch (name) {
		case "background1":
			background = BackgroundConfig.background1;
			break;
		case "background2":
			background = BackgroundConfig.background2;
			break;
		}
	}

	private void move() {
		switch (name) {
		case "background1":
			// x座標の遷移
			background.xpoints[BackgroundConfig.upper] += BackgroundConfig.upperIncreaseBackground1.x;
			background.xpoints[BackgroundConfig.right] += BackgroundConfig.rightIncreaseBackground1.x;
			background.xpoints[BackgroundConfig.left] += BackgroundConfig.leftIncreaseBackground1.x;
			// y座標の遷移
			background.ypoints[BackgroundConfig.upper] += BackgroundConfig.upperIncreaseBackground1.y;
			background.ypoints[BackgroundConfig.right] += BackgroundConfig.rightIncreaseBackground1.y;
			background.ypoints[BackgroundConfig.left] += BackgroundConfig.leftIncreaseBackground1.y;
			break;
		case "background2":
			// x座標の遷移
			background.xpoints[BackgroundConfig.upper] += BackgroundConfig.upperIncreaseBackground2.x;
			background.xpoints[BackgroundConfig.right] += BackgroundConfig.rightIncreaseBackground2.x;
			background.xpoints[BackgroundConfig.left] += BackgroundConfig.leftIncreaseBackground2.x;
			// y座標の遷移
			background.ypoints[BackgroundConfig.upper] += BackgroundConfig.upperIncreaseBackground2.y;
			background.ypoints[BackgroundConfig.right] += BackgroundConfig.rightIncreaseBackground2.y;
			background.ypoints[BackgroundConfig.left] += BackgroundConfig.leftIncreaseBackground2.y;
			break;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillPolygon(background);
	}
}
