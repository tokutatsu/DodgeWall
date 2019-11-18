package config;

import java.awt.Color;
import java.awt.Font;

public class RecordConfig {

	// ranking
	public static final int recordY = 280;
	public static final int distance = 10;
	public static final Font recordFont = new Font("メイリオ", Font.BOLD, 20);
	public static final Color recordColor = new Color(0, 0, 0);

	// rank, username, scoreのx座標
	public static final int rankX = 50;
	public static final int userNameX = 70;
	public static final int scoreX = 350;

	// エラーが出たとき
	public static final Color errorColor = new Color(0, 0, 0) ;
	public static final Font errorFont = new Font("メイリオ", Font.BOLD, 30);
	public static final int errorY = 350;
}
