package unit;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import config.BallConfig;

public class Ball extends Unit implements KeyListener {
	private Color color = new Color(0, 255, 0);  // 色は仮決め
	private Point point;
	private String name;

	// コンストラクタ
	public Ball(int windowHeight, String name) {
		this.name = name;
		switch (name) {
		case "ball2": point = BallConfig.ball2; break;  // 左のボール
		case "ball3": point = BallConfig.ball3; break;  // 右のボール
		}
	}

	// ボールの座標を取得
	public Point getPoint() {
		return point;
	}


	@Override
	public void keyTyped(KeyEvent e){
	}

	// 左右のキーを押したときのボールの移動
	@Override
	public void keyPressed(KeyEvent e){
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			if (name == "ball3") {
				point.x += BallConfig.moveDistance;
			}
			break;
		case KeyEvent.VK_LEFT:
			if (name == "ball2") {
				point.x -= BallConfig.moveDistance;
			}
			break;
		}
	}

	// 左右のキーを離したときのボールの移動
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			if (name == "ball3") {
				point.x -= BallConfig.moveDistance;
			}
			break;
		case KeyEvent.VK_LEFT:
			if (name == "ball2") {
				point.x += BallConfig.moveDistance;
			}
			break;
		}
	}

	// 描画メソッド
	@Override
	void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(point.x, point.y, BallConfig.size, BallConfig.size);
	}
}