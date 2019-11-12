package scene;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

import unit.Background;
import unit.Ball;
import unit.Lane;
import unit.Wall;

public class Play extends JPanel implements Runnable {
	private volatile Thread thread = null;
	private static int speed = 15;
	private static Background background1 = new Background("background1");
	private static Background background2 = new Background("background2");
	private static Lane back = new Lane("back");
	private static Lane lane1 = new Lane("lane1");
	private static Lane lane2 = new Lane("lane2");
	private static Lane lane3 = new Lane("lane3");
	private static Lane lane4 = new Lane("lane4");
	private static Wall wall1 = new Wall("wall1");
	private static Wall wall2 = new Wall("wall2");
	private static Ball ball1 = new Ball("ball1");
	private static Ball ball2 = new Ball("ball2");


	public Play() {
		JButton startBtn = new JButton("start");
		startBtn.addActionListener(e -> startThread());
		JButton stopBtn = new JButton("stop");
		stopBtn.addActionListener(e -> stopThread());
		add(startBtn); add(stopBtn);
		startThread();
	}

	private void startThread() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	private void stopThread() {
		thread = null;
	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		background1.draw(g);
		background2.draw(g);
		back.draw(g);
		lane1.draw(g);
		lane2.draw(g);
		lane3.draw(g);
		lane4.draw(g);
		wall1.draw(g);
		wall2.draw(g);
		ball1.draw(g);
		ball2.draw(g);
	}

	public void run() {
		Thread thisThread = Thread.currentThread();
		while (thread == thisThread) {
			if ( background1.isVisible() ) {
				background1.move();
			} else {
				background1 = new Background("background1");
			}
			if ( background2.isVisible() ) {
				background2.move();
			} else {
				background2 = new Background("background2");
			}
			if ( wall1.isVisible() ) {
				wall1.move();
			} else {
				wall1 = new Wall("wall1");
			}
			if ( wall2.isVisible() ) {
				wall2.move();
			} else {
				wall2 = new Wall("wall2");
			}
			repaint();
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {}
		}
	}

}
