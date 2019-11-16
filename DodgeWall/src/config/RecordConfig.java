package config;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

public class RecordConfig {

	// titleボタン
	public static final int titleButtonWidth = 120;
	public static final int titleButtonHeight = 30;
	public static final Point titleButtonPoint = new Point(WindowConfig.Width/2-titleButtonWidth, WindowConfig.Height*3/5);

	// exitボタン
	public static final int exitButtonWidth = 120;
	public static final int exitButtonHeight = 30;
	public static final Point exitButtonPoint = new Point(WindowConfig.Width/2, titleButtonPoint.y);

	// rankingボタン
	public static final int rankingY = 200;
	public static final Font rankingFont = new Font("メイリオ", Font.BOLD, 30);
	public static final Color rankingColor = new Color(0, 0, 0);

}
