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

	public Background(String name) {
		this.name = name;
		this.moveCount = 0;

		switch (name) {
		case "leftBackground":
			// 代入だと参照のためpointsごとに追加していく
			// backgroundの初期値
			for ( int i = 0; i < 3; i++ ) {
				background.addPoint(BackgroundConfig.leftBackground.xpoints[i], BackgroundConfig.leftBackground.ypoints[i]);
			}
			break;
		case "rightBackground":
			// backgroundの初期値
			for ( int i = 0; i < 3; i++ ) {
				background.addPoint(BackgroundConfig.rightBackground.xpoints[i], BackgroundConfig.rightBackground.ypoints[i]);
			}
			break;
		}
	}

	public void move() {
		switch (name) {
		case "leftBackground":
			// x座標の遷移
			background.xpoints[BackgroundConfig.upper] += BackgroundConfig.upperIncreaseleftBackground.x;
			background.xpoints[BackgroundConfig.right] += BackgroundConfig.rightIncreaseleftBackground.x;
			background.xpoints[BackgroundConfig.left] += BackgroundConfig.leftIncreaseleftBackground.x;
			// y座標の遷移
			background.ypoints[BackgroundConfig.upper] += BackgroundConfig.upperIncreaseleftBackground.y;
			background.ypoints[BackgroundConfig.right] += BackgroundConfig.rightIncreaseleftBackground.y;
			background.ypoints[BackgroundConfig.left] += BackgroundConfig.leftIncreaseleftBackground.y;
			break;
		case "rightBackground":
			// x座標の遷移
			background.xpoints[BackgroundConfig.upper] += BackgroundConfig.upperIncreaserightBackground.x;
			background.xpoints[BackgroundConfig.right] += BackgroundConfig.rightIncreaserightBackground.x;
			background.xpoints[BackgroundConfig.left] += BackgroundConfig.leftIncreaserightBackground.x;
			// y座標の遷移
			background.ypoints[BackgroundConfig.upper] += BackgroundConfig.upperIncreaserightBackground.y;
			background.ypoints[BackgroundConfig.right] += BackgroundConfig.rightIncreaserightBackground.y;
			background.ypoints[BackgroundConfig.left] += BackgroundConfig.leftIncreaserightBackground.y;
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

	public boolean nextTrigger() {
		if (moveCount == BackgroundConfig.frame/BackgroundConfig.pieces) {
			return true;
		}
		return false;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillPolygon(background);
	}
}
