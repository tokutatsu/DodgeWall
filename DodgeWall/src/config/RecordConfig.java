package config;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

public class RecordConfig {

	// head文字列
	public static final int headY = WindowConfig.Height/8;
	public static final Font headFont = new Font("メイリオ", Font.BOLD, 50);
	public static final Color headColor = new Color(0, 0, 0);

	// ranking
	public static final int recordY = WindowConfig.Height*3/13;
	public static final Font recordFont = new Font("メイリオ", Font.BOLD, 20);
	public static final Color recordColor = new Color(0, 0, 0);

	// rank, username, scoreのx座標
	public static final int rankX = 50;
	public static final int userNameX = 70;
	public static final int scoreX = 350;

	// titleボタン
	public static final int titleButtonWidth = 120;
	public static final int titleButtonHeight = 30;
	public static final Point titleButtonPoint = new Point(WindowConfig.Width/2-titleButtonWidth, WindowConfig.Height*4/5);

	// exitボタン
	public static final int exitButtonWidth = titleButtonWidth;
	public static final int exitButtonHeight = titleButtonHeight;
	public static final Point exitButtonPoint = new Point(WindowConfig.Width/2, titleButtonPoint.y);

}
