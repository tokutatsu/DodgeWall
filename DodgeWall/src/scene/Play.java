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
	private static ArrayList<Background> backgroundLeft = new ArrayList<Background>();
	private static ArrayList<Background> backgroundRight = new ArrayList<Background>();
	// レーン
	private static Lane back = new Lane("back");
	private static Lane lane1 = new Lane("lane1");
	private static Lane lane2 = new Lane("lane2");
	private static Lane lane3 = new Lane("lane3");
	private static Lane lane4 = new Lane("lane4");
	// 壁
	// wallLeftは左から2番目，wallRigthは左から3番目に現れる壁
	private static ArrayList<Wall> wallLeft = new ArrayList<Wall>();
	private static ArrayList<Wall> wallRigth = new ArrayList<Wall>();
	// ボール
	// ballLeft -> 左，ballRight -> 右
	private static Ball ballLeft = new Ball("ball2");
	private static Ball ballRight = new Ball("ball3");
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
		addKeyListener(ballLeft);
		addKeyListener(ballRight);
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
		backgroundLeft.forEach(b -> {b.draw(g);});
		backgroundRight.forEach(b -> {b.draw(g);});
		back.draw(g);
		lane1.draw(g);
		lane2.draw(g);
		lane3.draw(g);
		lane4.draw(g);
		// 描画の重なりの関係上逆順
		for ( i = wallLeft.size()-1; i >= 0 && wallLeft.get(i).getButtomLeft() > BallConfig.yBall; i-- ) {
				wallLeft.get(i).draw(g);
		}
		ballLeft.draw(g);
		for ( ; i >= 0; i-- ) {
				wallLeft.get(i).draw(g);
		}
		for ( i = wallRigth.size()-1; i >= 0 && wallRigth.get(i).getButtomLeft() > BallConfig.yBall; i-- ) {
				wallRigth.get(i).draw(g);
		}
		ballRight.draw(g);
		for ( ; i >= 0; i-- ) {
				wallRigth.get(i).draw(g);
		}

		// キー操作を有効にするために必要
		requestFocusInWindow();
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
		backgroundLeft.add(new Background("background1"));
		backgroundRight.add(new Background("background2"));
		if ( random.nextBoolean() ) {
			wallLeft.add(new Wall("wall2"));
		} else {
			wallLeft.add(new Wall("wall1"));
		}
		if ( random.nextBoolean() ) {
			wallRigth.add(new Wall("wallh3"));
		} else {
			wallRigth.add(new Wall("wall4"));
		}
	}

	// 各オブジェクトをmoveメソッドで動かす
	private void move() {
		for ( i = 0; i < backgroundLeft.size(); i++ ) {
			// 背景の数が背景の数の最大値(3)よりも少なくて，背景が画面から消える1/3まで進んだら次の壁をArrayListに追加する
			if ( backgroundLeft.get(i).nextTrigger() && backgroundLeft.size() < BackgroundConfig.pieces ) {
				backgroundLeft.add(new Background("background1"));
				backgroundLeft.get(i).move();
			// 背景が画面内にあれば背景をその動かす
			} else if ( backgroundLeft.get(i).isVisible() ) {
				backgroundLeft.get(i).move();
			// 背景が画面内になければその背景をArrayListから削除して新しい背景をArrayListに追加する．
			} else {
				backgroundLeft.remove(i);
				backgroundLeft.add(new Background("background1"));
			}
		}
		for ( i = 0; i < backgroundRight.size(); i++ ) {
			if ( backgroundRight.get(i).nextTrigger() && backgroundRight.size() < BackgroundConfig.pieces ) {
				backgroundRight.add(new Background("background2"));
				backgroundRight.get(i).move();
			} else if ( backgroundRight.get(i).isVisible() ) {
				backgroundRight.get(i).move();
			} else {
				backgroundRight.remove(i);
				backgroundRight.add(new Background("background2"));
			}
		}
		for ( i = 0; i < wallLeft.size(); i++ ) {
			if ( wallLeft.get(i).nextTrigger() && wallLeft.size() < WallConfig.pieces ) {
				if ( random.nextBoolean() ) {
					wallLeft.add(new Wall("wall2"));
				} else {
					wallLeft.add(new Wall("wall1"));
				}
				wallLeft.get(i).move();
			} else if ( wallLeft.get(i).isVisible() ) {
				wallLeft.get(i).move();
			} else {
				wallLeft.remove(i);
				if ( random.nextBoolean() ) {
					wallLeft.add(new Wall("wall2"));
				} else {
					wallLeft.add(new Wall("wall1"));
				}
			}
		}
		for ( i = 0; i < wallRigth.size(); i++ ) {
			if ( wallRigth.get(i).nextTrigger() && wallRigth.size() < WallConfig.pieces ) {
				if ( random.nextBoolean() ) {
					wallRigth.add(new Wall("wall3"));
				} else {
					wallRigth.add(new Wall("wall4"));
				}
				wallRigth.get(i).move();
			} else if ( wallRigth.get(i).isVisible() ) {
				wallRigth.get(i).move();
			} else {
				wallRigth.remove(i);
				if ( random.nextBoolean() ) {
					wallRigth.add(new Wall("wall3"));
				} else {
					wallRigth.add(new Wall("wall4"));
				}
			}
		}
	}

}
