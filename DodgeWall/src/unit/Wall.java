package unit;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import config.WallConfig;

public class Wall extends Unit {

	private Color color = WallConfig.color;
	private Polygon wall;
	private String name;

	public Wall(String name) {
		this.name = name;
		switch (name) {
		case "wall1":
			wall = WallConfig.wall1;
			break;
		case "wall2":
			wall = WallConfig.wall2;
			break;
		case "wall3":
			wall = WallConfig.wall3;
			break;
		case "wall4":
			wall = WallConfig.wall4;
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
	}

	@Override
	void draw(Graphics g) {
		g.setColor(color);
		g.fillPolygon(wall);
		g.setColor(new Color(0, 0, 0));
		g.drawPolygon(wall);
	}

}
