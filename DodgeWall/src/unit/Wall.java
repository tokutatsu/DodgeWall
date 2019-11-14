package unit;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import config.WallConfig;

public class Wall extends Unit {

	private Color color = WallConfig.color;
	private Polygon wall = new Polygon();
	private String name;
	private int moveCount;

	public Wall(String name) {
		this.name = name;
		this.moveCount = 0;

		switch (name) {
		case "wall1":
			// 壁1の初期値
			for ( int i = 0; i < 4; i++ ) {
				wall.addPoint(WallConfig.wall1.xpoints[i], WallConfig.wall1.ypoints[i]);
			}
			break;
		case "wall2":
			// 壁2の初期値
			for ( int i = 0; i < 4; i++ ) {
				wall.addPoint(WallConfig.wall2.xpoints[i], WallConfig.wall2.ypoints[i]);
			}
			break;
		case "wall3":
			// 壁3の初期値
			for ( int i = 0; i < 4; i++ ) {
				wall.addPoint(WallConfig.wall3.xpoints[i], WallConfig.wall3.ypoints[i]);
			}
			break;
		case "wall4":
			// 壁4の初期値
			for ( int i = 0; i < 4; i++ ) {
				wall.addPoint(WallConfig.wall4.xpoints[i], WallConfig.wall4.ypoints[i]);
			}
			break;
		}
	}

	public void move() {
		switch (name) {
		case "wall1":
			// x座標の遷移
			wall.xpoints[WallConfig.upperRight] += WallConfig.xRightIncreaseWall1;
			wall.xpoints[WallConfig.buttomRight] += WallConfig.xRightIncreaseWall1;
			wall.xpoints[WallConfig.buttomLeft] += WallConfig.xLeftIncreaseWall1;
			wall.xpoints[WallConfig.upperLeft] += WallConfig.xLeftIncreaseWall1;
			break;
		case "wall2":
			// x座標の遷移
			wall.xpoints[WallConfig.upperRight] += WallConfig.xRightIncreaseWall2;
			wall.xpoints[WallConfig.buttomRight] += WallConfig.xRightIncreaseWall2;
			wall.xpoints[WallConfig.buttomLeft] += WallConfig.xLeftIncreaseWall2;
			wall.xpoints[WallConfig.upperLeft] += WallConfig.xLeftIncreaseWall2;
			break;
		case "wall3":
			// x座標の遷移
			wall.xpoints[WallConfig.upperRight] += WallConfig.xRightIncreaseWall3;
			wall.xpoints[WallConfig.buttomRight] += WallConfig.xRightIncreaseWall3;
			wall.xpoints[WallConfig.buttomLeft] += WallConfig.xLeftIncreaseWall3;
			wall.xpoints[WallConfig.upperLeft] += WallConfig.xLeftIncreaseWall3;
			break;
		case "wall4":
			// x座標の遷移
			wall.xpoints[WallConfig.upperRight] += WallConfig.xRightIncreaseWall4;
			wall.xpoints[WallConfig.buttomRight] += WallConfig.xRightIncreaseWall4;
			wall.xpoints[WallConfig.buttomLeft] += WallConfig.xLeftIncreaseWall4;
			wall.xpoints[WallConfig.upperLeft] += WallConfig.xLeftIncreaseWall4;
			break;
		}
		// y座標の遷移
		wall.ypoints[WallConfig.upperRight] += WallConfig.yUpperIncrease;
		wall.ypoints[WallConfig.buttomRight] += WallConfig.yBottomIncrease;
		wall.ypoints[WallConfig.buttomLeft] += WallConfig.yBottomIncrease;
		wall.ypoints[WallConfig.upperLeft] += WallConfig.yUpperIncrease;

		moveCount++;
	}

	public boolean isVisible() {
		if (moveCount <= WallConfig.frame) {
			return true;
		}
		return false;
	}

	public boolean nextTrigger() {
		if (moveCount == WallConfig.frame/WallConfig.pieces) {
			return true;
		}
		return false;
	}

	public int getButtomLeft() {
		return wall.ypoints[WallConfig.buttomLeft];
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillPolygon(wall);
		g.setColor(new Color(0, 0, 0));
		g.drawPolygon(wall);
	}

}
