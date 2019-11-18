package unit;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import config.BackgroundConfig;

public class Background extends Unit {

	private Color color = BackgroundConfig.color;
	private Polygon background = new Polygon();
	private String name;
	private int moveCount;
	private int alpha = BackgroundConfig.alpha;

	public Background(String name) {
		this.name = name;
		this.moveCount = 0;

		switch (name) {
		case "leftBackground":
			// 代入だと参照のためpointsごとに追加していく
			// backgroundの初期値
			for ( int i = 0; i < 3; i++ ) {
				background.addPoint(BackgroundConfig.background1.xpoints[i], BackgroundConfig.background1.ypoints[i]);
			}
			break;
		case "rightBackground":
			// backgroundの初期値
			for ( int i = 0; i < 3; i++ ) {
				background.addPoint(BackgroundConfig.background2.xpoints[i], BackgroundConfig.background2.ypoints[i]);
			}
			break;
		}
	}

	public void move() {
		switch (name) {
		case "leftBackground":
			// x座標の遷移
			background.xpoints[BackgroundConfig.upper] += BackgroundConfig.upperIncreaseBackground1.x;
			background.xpoints[BackgroundConfig.right] += BackgroundConfig.rightIncreaseBackground1.x;
			background.xpoints[BackgroundConfig.left] += BackgroundConfig.leftIncreaseBackground1.x;
			// y座標の遷移
			background.ypoints[BackgroundConfig.upper] += BackgroundConfig.upperIncreaseBackground1.y;
			background.ypoints[BackgroundConfig.right] += BackgroundConfig.rightIncreaseBackground1.y;
			background.ypoints[BackgroundConfig.left] += BackgroundConfig.leftIncreaseBackground1.y;
			break;
		case "rightBackground":
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
		moveCount++;
	}

	public boolean isVisible() {
		if (moveCount <= BackgroundConfig.frame) {
			return true;
		}
		return false;
	}

	public boolean shouldCreateBackground() {
		if (moveCount == BackgroundConfig.frame/BackgroundConfig.pieces) {
			return true;
		}
		return false;
	}

	@Override
	public void draw(Graphics g) {
		if (alpha <= BackgroundConfig.maxAlpha) {
			color = new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
		}
		alpha += BackgroundConfig.alphaIncrease;
		g.setColor(color);
		g.fillPolygon(background);
	}
}
