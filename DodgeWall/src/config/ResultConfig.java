package config;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

public class ResultConfig {
	// 全部の文字
	public static final Color fontColor = new Color(0, 0, 0);

	// ハイスコアの表示
	public static final Font highScoreFont = new Font("メイリオ", Font.BOLD, 25);
	public static final int highScoreY = 230;

	// テキストフィールド
	public static final int inputUserNameHeight = 40;
	public static final int inputUserNameWidth = 200;
	public static final Point inputUserNamePoint = new Point(WindowConfig.Width/2 - inputUserNameWidth/2 -5, 300);
}
