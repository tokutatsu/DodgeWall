package scene;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

import config.BackgroundConfig;
import config.BallConfig;
import config.WallConfig;
import unit.Background;
import unit.Ball;
import unit.Lane;
import unit.Wall;

public class Play extends JPanel implements Runnable {

	// 壁をランダムに発生させるための乱数
	private static Random random = new Random();
	// 言わずもがなスレッド
	private volatile Thread thread = null;
	// 画面が切り替わるスピード
	// speedの値が大きいほど遅くなる
	private static int speed;
	// 背景
	// 追加したり削除したり賀しやすいためArrayListを採用
	private static ArrayList<Background> background1 = new ArrayList<Background>();
	private static ArrayList<Background> background2 = new ArrayList<Background>();
	// レーン
	private static Lane back = new Lane("back");
	private static Lane lane1 = new Lane("lane1");
	private static Lane lane2 = new Lane("lane2");
	private static Lane lane3 = new Lane("lane3");
	private static Lane lane4 = new Lane("lane4");
	// 壁
	// wall2は左から2番目，wall3は左から3番目に現れる壁
	private static ArrayList<Wall> wall2 = new ArrayList<Wall>();
	private static ArrayList<Wall> wall3 = new ArrayList<Wall>();
	// ボール
	// ball2 -> 左，ball3 -> 右
	private static Ball ball2 = new Ball("ball2");
	private static Ball ball3 = new Ball("ball3");
	// 一時変数
	private static int i;

	//コンストラクタ
	public Play() {
		speed = 30;
		JButton startBtn = new JButton("start");
		startBtn.addActionListener(e -> startThread());
		JButton stopBtn = new JButton("stop");
		stopBtn.addActionListener(e -> stopThread());
		add(startBtn);
		add(stopBtn);
		startThread();
	}

	// スレッドの開始
	private void startThread() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	// スレッドの停止
	private void stopThread() {
		thread = null;
	}

	// 画面描写
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
		for ( i = wall2.size()-1; i >= 0 && wall2.get(i).getButtomLeft() > BallConfig.yBall; i-- ) {
				wall2.get(i).draw(g);
		}
		ball2.draw(g);
		for ( ; i >= 0; i-- ) {
				wall2.get(i).draw(g);
		}
		for ( i = wall3.size()-1; i >= 0 && wall3.get(i).getButtomLeft() > BallConfig.yBall; i-- ) {
				wall3.get(i).draw(g);
		}
		ball3.draw(g);
		for ( ; i >= 0; i-- ) {
				wall3.get(i).draw(g);
		}
	}

	@Override
	public void run() {
		Thread thisThread = Thread.currentThread();
		// 背景と壁の初期化
		init();
		while (thread == thisThread) {
			// オブジェクトたちを動かす
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
		if ( random.nextBoolean() ) {
			wall2.add(new Wall("wall2"));
		} else {
			wall2.add(new Wall("wall1"));
		}
		if ( random.nextBoolean() ) {
			wall3.add(new Wall("wall3"));
		} else {
			wall3.add(new Wall("wall4"));
		}
	}

	// 各オブジェクトをmoveメソッドで動かす
	private void move() {
		for ( i = 0; i < background1.size(); i++ ) {
			// 背景の数が背景の数の最大値(3)よりも少なくて，背景が画面から消える1/3まで進んだら次の壁をArrayListに追加する
			if ( background1.get(i).nextTrigger() && background1.size() < BackgroundConfig.pieces ) {
				background1.add(new Background("background1"));
				background1.get(i).move();
			// 背景が画面内にあれば背景をその動かす
			} else if ( background1.get(i).isVisible() ) {
				background1.get(i).move();
			// 背景が画面内になければその背景をArrayListから削除して新しい背景をArrayListに追加する．
			} else {
				background1.remove(i);
				background1.add(new Background("background1"));
			}
		}
		for ( i = 0; i < background2.size(); i++ ) {
			if ( background2.get(i).nextTrigger() && background2.size() < BackgroundConfig.pieces ) {
				background2.add(new Background("background2"));
				background2.get(i).move();
			} else if ( background2.get(i).isVisible() ) {
				background2.get(i).move();
			} else {
				background2.remove(i);
				background2.add(new Background("background2"));
			}
		}
		for ( i = 0; i < wall2.size(); i++ ) {
			if ( wall2.get(i).nextTrigger() && wall2.size() < WallConfig.pieces ) {
				if ( random.nextBoolean() ) {
					wall2.add(new Wall("wall2"));
				} else {
					wall2.add(new Wall("wall1"));
				}
				wall2.get(i).move();
			} else if ( wall2.get(i).isVisible() ) {
				wall2.get(i).move();
			} else {
				wall2.remove(i);
				if ( random.nextBoolean() ) {
					wall2.add(new Wall("wall2"));
				} else {
					wall2.add(new Wall("wall1"));
				}
			}
		}
		for ( i = 0; i < wall3.size(); i++ ) {
			if ( wall3.get(i).nextTrigger() && wall3.size() < WallConfig.pieces ) {
				if ( random.nextBoolean() ) {
					wall3.add(new Wall("wall3"));
				} else {
					wall3.add(new Wall("wall4"));
				}
				wall3.get(i).move();
			} else if ( wall3.get(i).isVisible() ) {
				wall3.get(i).move();
			} else {
				wall3.remove(i);
				if ( random.nextBoolean() ) {
					wall3.add(new Wall("wall3"));
				} else {
					wall3.add(new Wall("wall4"));
				}
			}
		}
	}

}
