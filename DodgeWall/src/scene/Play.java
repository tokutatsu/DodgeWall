package scene;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

import config.BackgroundConfig;
import config.BallConfig;
import config.WallConfig;
import process.Judge;
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
	// 追加したり削除したりがしやすいためArrayListを採用
	private static ArrayList<Background> leftBackgroundList = new ArrayList<Background>();
	private static ArrayList<Background> rightBackgroundList = new ArrayList<Background>();
	// レーン
	private static Lane back = new Lane("back");
	private static Lane lane1 = new Lane("lane1");
	private static Lane lane2 = new Lane("lane2");
	private static Lane lane3 = new Lane("lane3");
	private static Lane lane4 = new Lane("lane4");
	// 壁
	// leftWallは左から2番目，rightWallは左から3番目に現れる壁
	private static ArrayList<Wall> leftWallList = new ArrayList<Wall>();
	private static ArrayList<Wall> rightWallList = new ArrayList<Wall>();
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
		leftBackgroundList.forEach(b -> {b.draw(g);});
		rightBackgroundList.forEach(b -> {b.draw(g);});
		back.draw(g);
		lane1.draw(g);
		lane2.draw(g);
		lane3.draw(g);
		lane4.draw(g);
		// 描画の重なりの関係上逆順
		for ( i = leftWallList.size()-1; i >= 0 && leftWallList.get(i).getButtomLeft() < BallConfig.yBall+BallConfig.size; i-- ) {
				leftWallList.get(i).draw(g);
		}
		leftBall.draw(g);
		for ( ; i >= 0; i-- ) {
				leftWallList.get(i).draw(g);
		}
		for ( i = rightWallList.size()-1; i >= 0 && rightWallList.get(i).getButtomLeft() < BallConfig.yBall+BallConfig.size; i-- ) {
				rightWallList.get(i).draw(g);
		}
		rightBall.draw(g);
		for ( ; i >= 0; i-- ) {
				rightWallList.get(i).draw(g);
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
			if ( Judge.hitJudge(leftBall, leftWallList, rightBall, rightWallList) ) { // 衝突判定を行う
				stopThread();
			}
			repaint();
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {}
		}
	}

	// ArrayListを初期化
	private void init() {
		leftBackgroundList.add(new Background("leftBackground"));
		rightBackgroundList.add(new Background("rightBackground"));
		if ( random.nextBoolean() ) {
			leftWallList.add(new Wall("wall2"));
		} else {
			leftWallList.add(new Wall("wall1"));
		}
		if ( random.nextBoolean() ) {
			rightWallList.add(new Wall("wall3"));
		} else {
			rightWallList.add(new Wall("wall4"));
		}
	}

	// 各オブジェクトをmoveメソッドで動かす
	private void move() {
		for ( i = 0; i < leftBackgroundList.size(); i++ ) {
			// 背景の数が背景の数の最大値(3)よりも少なくて，背景が画面から消える1/3まで進んだら次の壁をArrayListに追加する
			if ( leftBackgroundList.get(i).nextTrigger() && leftBackgroundList.size() < BackgroundConfig.pieces ) {
				leftBackgroundList.add(new Background("leftBackground"));
				leftBackgroundList.get(i).move();
			// 背景が画面内にあれば背景をその動かす
			} else if ( leftBackgroundList.get(i).isVisible() ) {
				leftBackgroundList.get(i).move();
			// 背景が画面内になければその背景をArrayListから削除して新しい背景をArrayListに追加する．
			} else {
				leftBackgroundList.remove(i);
				leftBackgroundList.add(new Background("leftBackground"));
			}
		}
		for ( i = 0; i < rightBackgroundList.size(); i++ ) {
			if ( rightBackgroundList.get(i).nextTrigger() && rightBackgroundList.size() < BackgroundConfig.pieces ) {
				rightBackgroundList.add(new Background("rightBackground"));
				rightBackgroundList.get(i).move();
			} else if ( rightBackgroundList.get(i).isVisible() ) {
				rightBackgroundList.get(i).move();
			} else {
				rightBackgroundList.remove(i);
				rightBackgroundList.add(new Background("rightBackground"));
			}
		}
		for ( i = 0; i < leftWallList.size(); i++ ) {
			if ( leftWallList.get(i).nextTrigger() && leftWallList.size() < WallConfig.pieces ) {
				if ( random.nextBoolean() ) {
					leftWallList.add(new Wall("wall2"));
				} else {
					leftWallList.add(new Wall("wall1"));
				}
				leftWallList.get(i).move();
			} else if ( leftWallList.get(i).isVisible() ) {
				leftWallList.get(i).move();
			} else {
				leftWallList.remove(i);
				if ( random.nextBoolean() ) {
					leftWallList.add(new Wall("wall2"));
				} else {
					leftWallList.add(new Wall("wall1"));
				}
			}
		}
		for ( i = 0; i < rightWallList.size(); i++ ) {
			if ( rightWallList.get(i).nextTrigger() && rightWallList.size() < WallConfig.pieces ) {
				if ( random.nextBoolean() ) {
					rightWallList.add(new Wall("wall3"));
				} else {
					rightWallList.add(new Wall("wall4"));
				}
				rightWallList.get(i).move();
			} else if ( rightWallList.get(i).isVisible() ) {
				rightWallList.get(i).move();
			} else {
				rightWallList.remove(i);
				if ( random.nextBoolean() ) {
					rightWallList.add(new Wall("wall3"));
				} else {
					rightWallList.add(new Wall("wall4"));
				}
			}
		}
	}

}
