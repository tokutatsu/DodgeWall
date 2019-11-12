package config;

import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;

public class BackgroundConfig {

	// ----------しばらくprivate----------------------------------

	private static final int x[] = {
			WindowConfig.Width/2,
			WindowConfig.Width/2,
			WindowConfig.Width/2,
	};

	private static final int y[] = {
			WindowConfig.Height/4,
			WindowConfig.Height/4,
			WindowConfig.Height/4,
	};


	// -------------------ここからpublic--------------------------

	// 背景の初期値
	// 右側の背景の座標の初期値
	public static final Polygon cordinateRight = new Polygon(x, y, 3);
	// 左側の背景の座標の初期値
	public static final Polygon cordinateLeft = new Polygon(x, y, 3);

	// 右側の背景の動き
	// 右側の背景の上の座標の動き
	public static final Point upperIncreaseBackground1 = new Point(-6, -5);
	// 右側の背景の右下の座標の動き
	public static final Point rightIncreaseBottomBackground1 = new Point(-4, 10);
	// 右側の背景の左下の座標の動き
	public static final Point leftIncreaseBottomBackground1 = new Point(-8, 10);

	// 左側の背景の動き
	// 左側の背景の上の座標の動き
	public static final Point upperIncreaseBackground2 = new Point(6, -5);
	// 左側の背景の右下の座標の動き
	public static final Point rightIncreaseBottomBackground2 = new Point(4, 10);
	// 左側の背景の左下の座標の動き
	public static final Point leftIncreaseBottomBackground2 = new Point(8, 10);

	// 1つの背景のフレーム数
	public static int frame = WindowConfig.Width/(2*leftIncreaseBottomBackground2.x);

	// 背景の色
	// 背景色の透明度の初期値
	public static final int alph = 0;
	// 背景の色の透明度の増加量
	public static final int alphIncrease = 255/frame;
	// 背景の色(透明度以外)
	public static final Color color = new Color(0, 0, 100);

}