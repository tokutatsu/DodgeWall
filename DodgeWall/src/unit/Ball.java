package unit;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import config.BallConfig;

public class Ball extends Unit implements KeyListener {
	private Color color = new Color(0, 255, 0);  // 色は仮決め
	private Point point = new Point();
	private String name;
	private int position;

	// コンストラクタ
	public Ball(String name) {
		this.name = name;
		switch (name) {
		case "leftBall":
//			point = BallConfig.ball2; break;  // 左のボール
			this.position = 2;
			point.x = BallConfig.ball2.x;
			point.y = BallConfig.ball2.y;
			break;
		case "rightBall":
//			point = BallConfig.ball3; break;  // 右のボール
			this.position = 3;
			point.x = BallConfig.ball3.x;
			point.y = BallConfig.ball3.y;
			break;
		}
	}

	// ボールの座標を取得
	public Point getPoint() {
		return point;
	}

	// ボールのポジションを取得
	public int getPosition() {
		return position;
	}


	@Override
	public void keyTyped(KeyEvent e) {
	}

	// 左右のキーを押したときのボールの移動
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			if (name == "rightBall") {
				position = 4;
				point.x = BallConfig.ball4.x;
			}
			break;
		case KeyEvent.VK_LEFT:
			if (name == "leftBall") {
				this.position = 1;
				point.x = BallConfig.ball1.x;
			}
			break;
		}
	}

	// 左右のキーを離したときのボールの移動
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			if (name == "rightBall")
				this.position = 3;{
					point.x = BallConfig.ball3.x;
			}
			break;
		case KeyEvent.VK_LEFT:
			if (name == "leftBall") {
				this.position = 2;
				point.x = BallConfig.ball2.x;
			}
			break;
		}
	}

	// 描画メソッド
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(point.x, point.y, BallConfig.size, BallConfig.size);
	}
}