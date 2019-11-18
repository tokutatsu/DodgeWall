package config;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

public class RecordConfig {

	// head文字列
	public static final int headY = WindowConfig.headY;
	public static final Font headFont = new Font("メイリオ", Font.BOLD, WindowConfig.headSize);
	public static final Color headColor = new Color(0, 0, 0);

	// ranking
	public static final int recordY = 240;
	public static final int distance = 5;
	public static final Font recordFont = new Font("メイリオ", Font.BOLD, 20);
	public static final Color recordColor = new Color(0, 0, 0);

	// rank, username, scoreのx座標
	public static final int rankX = 50;
	public static final int userNameX = 70;
	public static final int scoreX = 350;

	// titleボタン
	public static final int titleButtonWidth = WindowConfig.buttonWidthSize;
	public static final int titleButtonHeight = WindowConfig.buttonHeightSize;
	public static final Point titleButtonPoint = new Point(65, 580);

	// exitボタン
	public static final int exitButtonWidth = WindowConfig.buttonWidthSize;
	public static final int exitButtonHeight = WindowConfig.buttonHeightSize;;
	public static final Point exitButtonPoint = new Point(235, titleButtonPoint.y);

}
