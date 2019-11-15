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
	// 左側の背景の座標の初期値
	public static final Polygon leftBackground = new Polygon(x, y, 3);
	// 右側の背景の座標の初期値
	public static final Polygon rightBackground = new Polygon(x, y, 3);

	// 3角形の配置
	public static final int upper = 0;
	public static final int right = 1;
	public static final int left = 2;

	// 左側の背景の動き
	// 左側の背景の上の座標の動き
	public static final Point upperIncreaseleftBackground = new Point(-6, -5);
	// 左側の背景の右下の座標の動き
	public static final Point rightIncreaseleftBackground = new Point(-4, 10);
	// 左側の背景の左下の座標の動き
	public static final Point leftIncreaseleftBackground = new Point(-8, 10);

	// 右側の背景の動き
	// 右側の背景の上の座標の動き
	public static final Point upperIncreaserightBackground = new Point(6, -5);
	// 右側の背景の右下の座標の動き
	public static final Point rightIncreaserightBackground = new Point(4, 10);
	// 右側の背景の左下の座標の動き
	public static final Point leftIncreaserightBackground = new Point(8, 10);

	// 1つの背景のフレーム数
	public static final int frame = WindowConfig.Width/leftIncreaserightBackground.x;

	// 背景の色
	// 背景色の透明度の初期値
	public static final int alph = 0;
	// 背景の色の透明度の増加量
	public static final int alphIncrease = 255/frame;
	// 背景の色(透明度以外)
	public static final Color color = new Color(0, 0, 100);

	// 個数
	public static final int pieces = 3;

}