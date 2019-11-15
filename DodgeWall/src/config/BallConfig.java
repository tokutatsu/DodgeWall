package config;

import java.awt.Color;
import java.awt.Point;

public class BallConfig {

	// ボールのサイズ
	public static final int size = WindowConfig.Width/5;

	// ボールの色
	public static final Color color = new Color(0, 255, 0);

	// ボールの座標
	public static final int xBall = -size/4;
	public static final int yBall = WindowConfig.Height*4/5;

	// ボールの移動距離
	public static final int moveDistance = WindowConfig.Width/4+size/4;

	// ボールの座標
	// ball1 -> 一番左のレーンにいるとき ball2 -> 左から2番目のレーンにいるとき...
	public static final Point ball1 = new Point(xBall, yBall);
	public static final Point ball2 = new Point(xBall + moveDistance, yBall);
	public static final Point ball3 = new Point(xBall + moveDistance*2, yBall);
	public static final Point ball4 = new Point(xBall + moveDistance*3, yBall);

}
