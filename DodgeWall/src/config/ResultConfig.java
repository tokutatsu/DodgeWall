package config;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

public class ResultConfig {
	// 全部の文字
	public static final Color fontColor = new Color(0, 0, 0);

	// スコアの表示
	public static final Font scoreFont = new Font("メイリオ", Font.BOLD, WindowConfig.headSize);
	public static final int scoreY = WindowConfig.headY;

	// ハイスコアの表示
	public static final Font highScoreFont = new Font("メイリオ", Font.BOLD, 25);
	public static final int highScoreY = 230;

	// テキストフィールド
	public static final int inputUserNameHeight = 40;
	public static final int inputUserNameWidth = 200;
	public static final Point inputUserNamePoint = new Point(WindowConfig.Width/2 - inputUserNameWidth/2 -5, 300);

	// titleボタン
	public static final Point titleButtonPoint = new Point(35, 370);
	public static final int titleButtonWidth = WindowConfig.buttonWidthSize;
	public static final int titleButtonHeight = WindowConfig.buttonHeightSize;

	// retryボタン
	public static final Point retryButtonPoint = new Point(145, 370);
	public static final int retryButtonWidth = WindowConfig.buttonWidthSize;
	public static final int retryButtonHeight = WindowConfig.buttonHeightSize;

	// rankingボタン
	public static final Point rankingButtonPoint = new Point(255, 370);
	public static final int rankingButtonWidth = WindowConfig.buttonWidthSize;
	public static final int rankingButtonHeight = WindowConfig.buttonHeightSize;

	// exitボタン
	public static final Point exitButtonPoint = new Point(300, 700);
	public static final int exitButtonWidth = 70;
	public static final int exitButtonHeight = 30;
}
