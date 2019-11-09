import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Ball extends JPanel implements KeyListener {
//	private JPanel content = new JPanel();

	private int ballSize;
	private Color ballColor;
	private int ballMoveDistance;
	private Point ballPoint;
	private String ballName;


	// コンストラクタ
	public Ball(int windowHeight, String ballName) {

	}

	// ボールの座標を取得
	public Point getPoint() {
		return ballPoint;
	}


	@Override
	public void keyTyped(KeyEvent e){
	}

	@Override
	public void keyPressed(KeyEvent e){

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void paintComponent(Graphics g) {

	}
}