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
	private static ArrayList<Background> leftBackground = new ArrayList<Background>();
	private static ArrayList<Background> rightBackground = new ArrayList<Background>();
	// レーン
	private static Lane back = new Lane("back");
	private static Lane lane1 = new Lane("lane1");
	private static Lane lane2 = new Lane("lane2");
	private static Lane lane3 = new Lane("lane3");
	private static Lane lane4 = new Lane("lane4");
	// 壁
	// leftWallは左から2番目，wallRigthは左から3番目に現れる壁
	private static ArrayList<Wall> leftWall = new ArrayList<Wall>();
	private static ArrayList<Wall> rightWall = new ArrayList<Wall>();
	// ボール
	// leftBall -> 左，rightBall -> 右
	private static Ball leftBall = new Ball("leftBall");
	private static Ball rightBall = new Ball("rightBall");
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
		addKeyListener(leftBall);
		addKeyListener(rightBall);
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
		leftBackground.forEach(b -> {b.draw(g);});
		rightBackground.forEach(b -> {b.draw(g);});
		back.draw(g);
		lane1.draw(g);
		lane2.draw(g);
		lane3.draw(g);
		lane4.draw(g);
		// 描画の重なりの関係上逆順
		for ( i = leftWall.size()-1; i >= 0 && leftWall.get(i).getButtomLeft() > BallConfig.yBall; i-- ) {
				leftWall.get(i).draw(g);
		}
		leftBall.draw(g);
		for ( ; i >= 0; i-- ) {
				leftWall.get(i).draw(g);
		}
		for ( i = rightWall.size()-1; i >= 0 && rightWall.get(i).getButtomLeft() > BallConfig.yBall; i-- ) {
				rightWall.get(i).draw(g);
		}
		rightBall.draw(g);
		for ( ; i >= 0; i-- ) {
				rightWall.get(i).draw(g);
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
		leftBackground.add(new Background("leftBackground"));
		rightBackground.add(new Background("rightBackground"));
		if ( random.nextBoolean() ) {
			leftWall.add(new Wall("wall2"));
		} else {
			leftWall.add(new Wall("wall1"));
		}
		if ( random.nextBoolean() ) {
			rightWall.add(new Wall("wall3"));
		} else {
			rightWall.add(new Wall("wall4"));
		}
	}

	// 各オブジェクトをmoveメソッドで動かす
	private void move() {
		for ( i = 0; i < leftBackground.size(); i++ ) {
			// 背景の数が背景の数の最大値(3)よりも少なくて，背景が画面から消える1/3まで進んだら次の壁をArrayListに追加する
			if ( leftBackground.get(i).nextTrigger() && leftBackground.size() < BackgroundConfig.pieces ) {
				leftBackground.add(new Background("leftBackground"));
				leftBackground.get(i).move();
			// 背景が画面内にあれば背景をその動かす
			} else if ( leftBackground.get(i).isVisible() ) {
				leftBackground.get(i).move();
			// 背景が画面内になければその背景をArrayListから削除して新しい背景をArrayListに追加する．
			} else {
				leftBackground.remove(i);
				leftBackground.add(new Background("leftBackground"));
			}
		}
		for ( i = 0; i < rightBackground.size(); i++ ) {
			if ( rightBackground.get(i).nextTrigger() && rightBackground.size() < BackgroundConfig.pieces ) {
				rightBackground.add(new Background("rightBackground"));
				rightBackground.get(i).move();
			} else if ( rightBackground.get(i).isVisible() ) {
				rightBackground.get(i).move();
			} else {
				rightBackground.remove(i);
				rightBackground.add(new Background("rightBackground"));
			}
		}
		for ( i = 0; i < leftWall.size(); i++ ) {
			if ( leftWall.get(i).nextTrigger() && leftWall.size() < WallConfig.pieces ) {
				if ( random.nextBoolean() ) {
					leftWall.add(new Wall("wall2"));
				} else {
					leftWall.add(new Wall("wall1"));
				}
				leftWall.get(i).move();
			} else if ( leftWall.get(i).isVisible() ) {
				leftWall.get(i).move();
			} else {
				leftWall.remove(i);
				if ( random.nextBoolean() ) {
					leftWall.add(new Wall("wall2"));
				} else {
					leftWall.add(new Wall("wall1"));
				}
			}
		}
		for ( i = 0; i < rightWall.size(); i++ ) {
			if ( rightWall.get(i).nextTrigger() && rightWall.size() < WallConfig.pieces ) {
				if ( random.nextBoolean() ) {
					rightWall.add(new Wall("wall3"));
				} else {
					rightWall.add(new Wall("wall4"));
				}
				rightWall.get(i).move();
			} else if ( rightWall.get(i).isVisible() ) {
				rightWall.get(i).move();
			} else {
				rightWall.remove(i);
				if ( random.nextBoolean() ) {
					rightWall.add(new Wall("wall3"));
				} else {
					rightWall.add(new Wall("wall4"));
				}
			}
		}
	}

}
