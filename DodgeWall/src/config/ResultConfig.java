package config;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

public class ResultConfig {
	// 全部の文字
	public static final Color fontColor = new Color(0, 0, 0);

	// スコアの表示
	public static final Font scoreFont = new Font("メイリオ", Font.BOLD, 50);
	public static final int scoreY = 120;

	// ハイスコアの表示
	public static final Font highScoreFont = new Font("メイリオ", Font.BOLD, 25);
	public static final int highScoreY = 150;

	// テキストフィールド
	public static final int inputUserNameY = 200;
	public static final int inputUserNameHeight = 40;
	public static final int inputUserNameWidth = 200;

	// titleボタン
	public static final Point titleButtonPoint = new Point(40, 270);
	public static final int titleButtonWidth = 100;
	public static final int titleButtonHeight = 40;

	// retryボタン
	public static final Point retryButtonPoint = new Point(150, 270);
	public static final int retryButtonWidth = 100;
	public static final int retryButtonHeight = 40;

	// rankingボタン
	public static final Point rankingButtonPoint = new Point(260, 270);
	public static final int rankingButtonWidth = 100;
	public static final int rankingButtonHeight = 40;

	// exitボタン
	public static final Point exitButtonPoint = new Point(300, 700);
	public static final int exitButtonWidth = 70;
	public static final int exitButtonHeight = 30;
}
