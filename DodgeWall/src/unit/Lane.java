package unit;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import config.LaneConfig;

public class Lane extends Unit {

	private Polygon lane;
	private Color color;

	// コンストラクタ
	public Lane(String name) {
		switch (name) {
		case "lane1":
			lane = LaneConfig.lane1;
			color = LaneConfig.laneColor;
			break;
		case "lane2":
			lane = LaneConfig.lane2;
			color = LaneConfig.laneColor;
			break;
		case "lane3":
			lane = LaneConfig.lane3;
			color = LaneConfig.laneColor;
			break;
		case "lane4":
			lane = LaneConfig.lane4;
			color = LaneConfig.laneColor;
			break;
		case "back":
			lane = LaneConfig.back;
			color = LaneConfig.backColor;
			break;
		}
	}

	// レーンの座標(ポリゴン)を取得
	public Polygon getPolygon() {
		return lane;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillPolygon(lane);
	}
}
