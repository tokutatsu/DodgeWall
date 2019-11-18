package config;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

public class WindowConfig {

	// window全体のサイズ
	public static final int Height = 800;
	public static final int Width = Height/2;

	// 画面上部の文字
	public static final int headY = 200;
	public static final Font headFont = new Font("メイリオ", Font.BOLD, 50);
	public static final Color headColor = new Color(0, 0, 0);

	// 一般のボタンの大きさ
	public static final int buttonHeight = 40;
	public static final int buttonWidth = 100;
	public static final Point leftButtonPoint = new Point(70, 480);
	public static final Point rightButtonPoint = new Point(220, 480);

	// titleボタンの大きさと位置
	public static final Point titleButtonPoint = new Point(25, 700);
	public static final int titleButtonWidth = 70;
	public static final int titleButtonHeight = 30;

	// exitボタンの大きさと位置
	public static final Point exitButtonPoint = new Point(295, 700);
	public static final int exitButtonWidth = 70;
	public static final int exitButtonHeight = 30;
}
