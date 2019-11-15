package unit;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import config.BallConfig;

public class Ball extends Unit implements KeyListener {
	private Color color = BallConfig.color;  // 色は仮決め
	private Point point;
	private String name;
	private int position;

	// コンストラクタ
	public Ball(String name) {
		this.name = name;
		switch (name) {
		case "leftBall":
			// 左のボール
			this.position = 2;
			this.point = new Point(BallConfig.ball2.x, BallConfig.ball2.y);
			break;
		case "rightBall":
			// 右のボール
			this.position = 3;
			this.point = new Point(BallConfig.ball3.x, BallConfig.ball3.y);
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
				point.setLocation(BallConfig.ball4);
			}
			break;
		case KeyEvent.VK_LEFT:
			if (name == "leftBall") {
				position = 1;
				point.setLocation(BallConfig.ball1);
			}
			break;
		}
	}

	// 左右のキーを離したときのボールの移動
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			if (name == "rightBall") {
				position = 3;
				point.setLocation(BallConfig.ball3);
			}
			break;
		case KeyEvent.VK_LEFT:
			if (name == "leftBall") {
				position = 2;
				point.setLocation(BallConfig.ball2);
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