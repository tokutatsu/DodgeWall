package config;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

public class TitleConfig {

	// title
	public static final int titleY = 200;
	public static final String titleName = new String("DODGE WALL");
	public static final Font titleFont = new Font("メイリオ", Font.BOLD, 50);
	public static final Color titleColor = new Color(0, 0, 0);

	// startボタン
	public static final int startButtonWidth = 120;
	public static final int startButtonHeight = 30;
	public static final Point startButtonPoint = new Point((WindowConfig.Width-startButtonWidth)/2, WindowConfig.Height*3/5);

	// rankingボタン
	public static final int rankingButtonWidth = startButtonWidth;
	public static final int rankingButtonHeight = startButtonHeight;
	public static final Point rankingButtonPoint = new Point((WindowConfig.Width-rankingButtonWidth)/2, startButtonPoint.y+startButtonHeight+10);

	// exitボタン
	public static final int exitButtonWidth = startButtonWidth;
	public static final int exitButtonHeight = startButtonHeight;
	public static final Point exitButtonPoint = new Point((WindowConfig.Width-rankingButtonWidth)/2, rankingButtonPoint.y+rankingButtonHeight+10);

}
