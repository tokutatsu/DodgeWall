package config;

import java.awt.Color;
import java.awt.Font;

public class TitleConfig {

	// title
	public static final int titleY = 120;
	public static final String titleName = new String("Dodge Wall");
	public static final Font titleFont = new Font("メイリオ", Font.BOLD, 50);
	public static final Color titleColor = new Color(0, 0, 0);

	// username
	public static final int usernameY = 180;
	public static final String usernameInit = new String("guest user");
	public static final Font usernameFont = new Font("メイリオ", Font.BOLD, 30);
	public static final Color usernameColor = new Color(0, 0, 0);

	// textFieldボタンとaddボタン
	public static final int textFieldWidth = 140;
	public static final int textFieldHeight = 30;
	public static final int addButtonWidth = 60;
	public static final int addButtonHeight = 30;

	public static final int textFieldX = WindowConfig.Width/2-(textFieldWidth+addButtonWidth)/2;
	public static final int textFieldY = 200;
	public static final int addButtonX = textFieldX+textFieldWidth;
	public static final int addButtonY = 200;

	// startボタン
	public static final int startButtonWidth = 120;
	public static final int startButtonHeight = 30;
	public static final int startButtonX = WindowConfig.Width/2-startButtonWidth/2;
	public static final int startButtonY = WindowConfig.Height*5/8;

	// rankingボタン
	public static final int rankingButtonWidth = startButtonWidth;
	public static final int rankingButtonHeight = startButtonHeight;
	public static final int rankingButtonX = WindowConfig.Width/2-rankingButtonWidth/2;
	public static final int rankingButtonY = startButtonY+startButtonHeight+10;

	// exitボタン
	public static final int exitButtonWidth = startButtonWidth;
	public static final int exitButtonHeight = startButtonHeight;
	public static final int exitButtonX = WindowConfig.Width/2-rankingButtonWidth/2;
	public static final int exitButtonY = rankingButtonY+rankingButtonHeight+10;

}
