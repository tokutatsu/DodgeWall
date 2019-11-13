package scene;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import config.BackgroundConfig;
import unit.Background;
import unit.Ball;
import unit.Lane;
import unit.Wall;

public class Play extends JPanel implements Runnable {
	private volatile Thread thread = null;
	private static int speed;
	private static ArrayList<Background> background1 = new ArrayList<Background>();
	private static ArrayList<Background> background2 = new ArrayList<Background>();
	private static Lane back = new Lane("back");
	private static Lane lane1 = new Lane("lane1");
	private static Lane lane2 = new Lane("lane2");
	private static Lane lane3 = new Lane("lane3");
	private static Lane lane4 = new Lane("lane4");
	private static ArrayList<Wall> wall2 = new ArrayList<Wall>();
	private static ArrayList<Wall> wall3 = new ArrayList<Wall>();
	private static Ball ball2 = new Ball("ball2");
	private static Ball ball3 = new Ball("ball3");


	public Play() {
		speed = 15;
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
		background1.forEach(b -> {b.draw(g);});
		background2.forEach(b -> {b.draw(g);});
		back.draw(g);
		lane1.draw(g);
		lane2.draw(g);
		lane3.draw(g);
		lane4.draw(g);
		wall2.forEach(w -> {w.draw(g);});
		wall3.forEach(w -> {w.draw(g);});
		ball2.draw(g);
		ball3.draw(g);
	}

	@Override
	public void run() {
		Thread thisThread = Thread.currentThread();
		init();
		while (thread == thisThread) {
			move();
			repaint();
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {}
		}
	}

	// ArrayListを初期化
	private void init() {
		background1.add(new Background("background1"));
		background2.add(new Background("background2"));
		wall2.add(new Wall("wall2"));
		wall3.add(new Wall("wall3"));
	}

	// 各オブジェクトをmoveメソッドで動かす
	private void move() {
//		for ( Background b : background1 ) {
//			if ( b.nextTrigger() && background1.size() < BackgroundConfig.pieces ) {
//				b.move();
//				background1.add(new Background("background1"));
//			} else if ( b.isVisible() ) {
//				b.move();
//			} else {
//				background1.remove(b);
//				background1.add(new Background("background1"));
//			}
//		}
		for ( int i = 0; i < background1.size(); i++ ) {
			if ( background1.get(i).nextTrigger() && background1.size() < BackgroundConfig.pieces ) {
				background1.get(i).move();
				background1.add(new Background("background1"));
			} else if ( background1.get(i).isVisible() ) {
				background1.get(i);
			} else {
				background1.remove(i);
				background1.add(new Background("background1"));
			}
		}
		for ( Background b : background2 ) {
			if ( b.isVisible() ) {
				b.move();
			} else {
				background2.remove(b);
				background2.add(new Background("background2"));
			}
		}
		for ( Wall w : wall2 ) {
			if ( w.isVisible() ) {
				w.move();
			} else {
				wall2.remove(w);
				wall2.add(new Wall("wall2"));
			}
		}
		for ( Wall w : wall3 ) {
			if ( w.isVisible() ) {
				w.move();
			} else {
				wall3.remove(w);
				wall3.add(new Wall("wall3"));
			}
		}
	}

}
