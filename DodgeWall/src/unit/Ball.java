package unit;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ball extends Unit implements KeyListener {
	private int size;
	private Color color = new Color(0, 255, 0);  // 色は仮決め
	private int moveDistance;
	private Point point;
	private String name;

	private int windowWidth;


	// コンストラクタ
	public Ball(int windowHeight, String ballName) {
		windowWidth = windowHeight / 2;
		size = windowWidth / 5;
		moveDistance = (windowWidth + size) / 4;  // hiranyのボールの座標から引き算で逆算(後で調整)
		name = ballName;
		int y = windowHeight * 4 / 5;


		switch (name) {
		case "rightBall": point = new Point(windowWidth / 2 + size / 4, y); break;
		case "leftBall": point = new Point(windowWidth / 4, y); break;
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
			if (name == "rightBall") {
				point.x += moveDistance;
			}
			break;
		case KeyEvent.VK_LEFT:
			if (name == "leftBall") {
				point.x -= moveDistance;
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
				point.x -= moveDistance;
			}
			break;
		case KeyEvent.VK_LEFT:
			if (name == "leftBall") {
				point.x += moveDistance;
			}
			break;
		}
	}

	// 描画メソッド
	@Override
	void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(point.x, point.y, size, size);
	}
}