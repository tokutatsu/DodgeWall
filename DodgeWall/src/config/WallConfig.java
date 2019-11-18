package config;

import java.awt.Color;
import java.awt.Polygon;

public class WallConfig {

	// ------------------------------しばらくprivate--------------------------

	// 壁の縦のサイズ
	private static int heightSize = 10;
	// 壁のx座標
	// xWall1 -> 左端の壁，xWall2 -> 左の壁
	// xWall[0] -> 右上, xWall[1] -> 右下, xWall[2] -> 左下, xWall[3] -> 左上
	private static final int xWall1[] = {
			LaneConfig.lane1.xpoints[3]+LaneConfig.border*3,
			LaneConfig.lane1.xpoints[0]-LaneConfig.border,
			LaneConfig.lane1.xpoints[3]+LaneConfig.border,
			LaneConfig.lane1.xpoints[0]-LaneConfig.border*3,
	};
	private static final int xWall2[] = {
			LaneConfig.lane2.xpoints[3]+LaneConfig.border*3,
			LaneConfig.lane2.xpoints[0]-LaneConfig.border,
			LaneConfig.lane2.xpoints[3]+LaneConfig.border,
			LaneConfig.lane2.xpoints[0]-LaneConfig.border*3,
	};
	private static final int xWall3[] = {
			LaneConfig.lane3.xpoints[3]+LaneConfig.border*3,
			LaneConfig.lane3.xpoints[0]-LaneConfig.border,
			LaneConfig.lane3.xpoints[3]+LaneConfig.border,
			LaneConfig.lane3.xpoints[0]-LaneConfig.border*3,
	};
	private static final int xWall4[] = {
			LaneConfig.lane4.xpoints[0]+LaneConfig.border*3,
			LaneConfig.lane4.xpoints[3]-LaneConfig.border,
			LaneConfig.lane4.xpoints[0]+LaneConfig.border,
			LaneConfig.lane4.xpoints[3]-LaneConfig.border*3,
	};
	// 壁のy座標
	// yWall[0] -> 右上，yWall[1] -> 右下, yWall[2] -> 左下, yWall[3] -> 左上
	private static final int yWall[] = {
			LaneConfig.lane1.ypoints[0]-heightSize,
			LaneConfig.lane1.ypoints[0],
			LaneConfig.lane1.ypoints[0],
			LaneConfig.lane1.ypoints[0]-heightSize,
	};


	// ------------------------------ここからpublic--------------------------


	// 4角形の配置
	public static final int upperRight = 0;
	public static final int buttomRight = 1;
	public static final int buttomLeft = 2;
	public static final int upperLeft = 3;

	// 壁のx方向の動き 左から1番目のレーン
	// xRightIncrease -> 右上，右下
	// xLeftIncrease -> 左上，左下
	public static final int xRightIncreaseWall1 = -1;
	public static final int xLeftIncreaseWall1 = -2;
	// 壁のx方向の動き 左から2番目のレーン
	public static final int xRightIncreaseWall2 = 0;
	public static final int xLeftIncreaseWall2 = -1;
	// 壁のx方向の動き 左から3番目のレーン
	public static final int xRightIncreaseWall3 = 1;
	public static final int xLeftIncreaseWall3 = 0;
	// 壁のx方向の動き 左から4番目のレーン
	public static final int xRightIncreaseWall4 = 2;
	public static final int xLeftIncreaseWall4 = 1;

	// 壁のy方向の動き
	// yUpperIncrease -> 右上，左上
	// yBottomIncrease -> 右下，左下
	public static final int yUpperIncrease = 4;
	public static final int yBottomIncrease = 5;

	// 壁の座標を示すポリゴン
	// wall1 -> 左から1番目の壁, wall2 -> 左から2番目の壁, wall3 -> 左から3番目の壁，wall4 -> 左から4番目の壁
	public static final Polygon wall1 = new Polygon(xWall1, yWall, 4);
	public static final Polygon wall2 = new Polygon(xWall2, yWall, 4);
	public static final Polygon wall3 = new Polygon(xWall3, yWall, 4);
	public static final Polygon wall4 = new Polygon(xWall4, yWall, 4);

	// 1つの壁のフレームの数
	// 壁が出現してから消えるまでの数
	public static int frame = (WindowConfig.Height-yWall[0])/yUpperIncrease;
	// 壁の色の透明度の初期値
	public static final int alpha = 0;
	// 壁の色の透明度の最大値
	public static final int maxAlpha = 255;
	// 壁の色の透明度の増加量
	public static final int alphaIncrease = maxAlpha/frame*2;
	// 壁の色
	public static final Color color = new Color(255, 0, 255, alpha);

	// 個数
	public static final int pieces = 5;

}
