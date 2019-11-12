package config;

import java.awt.Color;
import java.awt.Polygon;

public class LaneConfig {


	// ----------------しばらくprivate----------------------------------

	// レーンの幅
	private static final int upperWidth = WindowConfig.Width/25;
	private static final int bottomWidth = WindowConfig.Width*25/68;
	// レーンの間の溝の幅 publicだけどprivateで使うからここ
	public static final int border = WindowConfig.Width/100;

	// polygonを作成するための配列
	// 左から1, 2, 3, 4とみる
	private static final int xLane1[] = {
			WindowConfig.Width/2-upperWidth-border*2,
			WindowConfig.Width/2-bottomWidth-border*2,
			WindowConfig.Width/2-bottomWidth*2-border*2,
			WindowConfig.Width/2-upperWidth*2-border*2,
	};
	private static final int xLane2[] = {
			WindowConfig.Width/2-border,
			WindowConfig.Width/2-border,
			WindowConfig.Width/2-bottomWidth-border,
			WindowConfig.Width/2-upperWidth-border,
	};
	private static final int xLane3[] = {
			WindowConfig.Width/2+upperWidth+border,
			WindowConfig.Width/2+bottomWidth+border,
			WindowConfig.Width/2+border,
			WindowConfig.Width/2+border,
	};
	private static final int xLane4[] = {
			WindowConfig.Width/2+upperWidth+border*2,
			WindowConfig.Width/2+bottomWidth+border*2,
			WindowConfig.Width/2+bottomWidth*2+border*2,
			WindowConfig.Width/2+upperWidth*2+border*2,
	};
	private static final int yLane[] = {
			WindowConfig.Height*3/10,
			WindowConfig.Height,
			WindowConfig.Height,
			WindowConfig.Height*3/10,
	};
	// レーンの下に表示するための背景
	private static final int xBack[] = {
			xLane4[0]+border,
			xLane4[1]+border,
			xLane1[2]-border,
			xLane1[3]-border,
	};
	private static final int yBack[] = {
			yLane[0]+border,
			yLane[1]-border,
			yLane[2]-border,
			yLane[3]+border,
	};



	// -------------publicとして使用するのはここから-------------------------

	// レーンの座標を示すポリゴン
	// 左から1, 2, 3, 4とみる
	public static final Polygon lane1 = new Polygon(xLane1, yLane, 4);
	public static final Polygon lane2 = new Polygon(xLane2, yLane, 4);
	public static final Polygon lane3 = new Polygon(xLane3, yLane, 4);
	public static final Polygon lane4 = new Polygon(xLane4, yLane, 4);
	// レーンの下に表示する背景の座標を示すポリゴン
	public static final Polygon back = new Polygon(xBack, yBack, 4);
	// レーンの色
	public static final Color color = new Color(255, 255, 150);
	// レーンの下の背景の色
	public static final Color backColor = new Color(255, 255, 255);

}
