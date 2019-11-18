package scene;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import config.BackgroundConfig;
import config.BallConfig;
import config.PlayConfig;
import config.WallConfig;
import config.WindowConfig;
import process.Judge;
import process.Score;
import unit.Background;
import unit.Ball;
import unit.Lane;
import unit.Wall;

public class Play extends JPanel implements Runnable {

	// 壁をランダムに発生させるための乱数
	private Random random = new Random();
	// 言わずもがなスレッド
	private volatile Thread thread = null;
	// 画面が切り替わるスピード
	// sleepTimeの値が大きいほど遅くなる
	private int sleepTime;
	// 背景
	// 追加したり削除したりがしやすいためArrayListを採用
	private ArrayList<Background> leftBackgroundList = new ArrayList<Background>();
	private ArrayList<Background> rightBackgroundList = new ArrayList<Background>();
	// レーン
	private Lane back = new Lane("back");
	private Lane lane1 = new Lane("lane1");
	private Lane lane2 = new Lane("lane2");
	private Lane lane3 = new Lane("lane3");
	private Lane lane4 = new Lane("lane4");
	// 壁
	// leftWallは左から2番目，rightWallは左から3番目に現れる壁
	private ArrayList<Wall> leftWallList = new ArrayList<Wall>();
	private ArrayList<Wall> rightWallList = new ArrayList<Wall>();
	// ボール
	// leftBall -> 左，rightBall -> 右
	private Ball leftBall = new Ball("leftBall");
	private Ball rightBall = new Ball("rightBall");
	// 一時変数
	private Screen screen;

	// ゲームオーバーのラベル
	private JLabel gameOverLabel = new JLabel("GAME OVER");

	//コンストラクタ
	public Play(Screen screen) {
		this.screen = screen;
		sleepTime = PlayConfig.maxSleepTime;
		JButton startBtn = new JButton("start");
		startBtn.addActionListener(e -> startThread());
		JButton stopBtn = new JButton("stop");
		stopBtn.addActionListener(e -> stopThread());
		add(startBtn);
		add(stopBtn);
		addKeyListener(leftBall);
		addKeyListener(rightBall);
		init();
		Score.init();
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
		int i;
		super.paintComponent(g);
		for ( i = 0; i < leftBackgroundList.size(); i++ ) {
			leftBackgroundList.get(i).draw(g);
		}
		for ( i = 0; i < rightBackgroundList.size(); i++ ) {
			rightBackgroundList.get(i).draw(g);
		}
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
		while (thread == thisThread) {
			// オブジェクトたちを動かす
			move();
			if ( Judge.hitJudge(leftBall, leftWallList, rightBall, rightWallList) ) { // 衝突判定を行う
				gameOverLabel.setFont(PlayConfig.font);
				int width = gameOverLabel.getFontMetrics(PlayConfig.font).stringWidth("GAME OVER");
				gameOverLabel.setBounds((WindowConfig.Width-width)/2, PlayConfig.positionY, width, PlayConfig.height);
				add(gameOverLabel);
				repaint();
				try {
					Thread.sleep(PlayConfig.displayTime);
				} catch (InterruptedException e) {}
				stopThread();
				screen.changeJPanel(new Result(Score.getScore(), screen));
			}
			repaint();
			try {
				Thread.sleep(sleepTime);
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
		// 左の背景
		// 背景を動かす
		for ( int i = 0; i < leftBackgroundList.size(); i++ ) {
			leftBackgroundList.get(i).move();
		}
		// 背景の数が背景の数の最大値(3)よりも少なくて，背景が画面から消える1/3まで進んだら次の壁をArrayListに追加する
		if ( leftBackgroundList.size() < BackgroundConfig.pieces && leftBackgroundList.get(leftBackgroundList.size()-1).nextTrigger() ) {
			leftBackgroundList.add(new Background("leftBackground"));
		}
		// 背景が画面内になければその背景をArrayListから削除する．
		if ( !leftBackgroundList.get(0).isVisible() ) {
			leftBackgroundList.remove(0);
			leftBackgroundList.add(new Background("leftBackground"));
		}
		// 右の背景
		// 背景を動かす
		for ( int i = 0; i < rightBackgroundList.size(); i++ ) {
			rightBackgroundList.get(i).move();
		}
		// 背景の数が背景の数の最大値(3)よりも少なくて，背景が画面から消える1/3まで進んだら次の壁をArrayListに追加する
		if ( righttBackgroundList.size() < BackgroundConfig.pieces && rightBackgroundList.get(rightBackgroundList.size()-1).nextTrigger() ) {
			rightBackgroundList.add(new Background("righBackground"));
		}
		// 背景が画面内になければその背景をArrayListから削除する．
		if ( !rightBackgroundList.get(0).isVisible() ) {
			rightBackgroundList.remove(0);
			rightBackgroundList.add(new Background("righBackground"));
		}
		// 左の壁
		if ( leftWallist.size() < WallConfig.pieces && WallList.get(WallList.size()-1).nextTrigger() ) {
			if ( random.nextBoolean() ) {
				leftWallList.add(new Wall("wall2"));
			} else {
				leftWallList.add(new Wall("wall1"));
			}
		}
		if ( !leftWallList.get(0).isVisible() ) {
			leftWallList.remove(0);
			if ( random.nextBoolean() ) {
				leftWallList.add(new Wall("wall2"));
			} else {
				leftWallList.add(new Wall("wall1"));
			}
		}
		for ( int i = 0; i < leftWallList.size(); i++ ) {
			leftWallList.move();
		}
		// 右の壁
		if ( rightWallist.size() < WallConfig.pieces && WallList.get(WallList.size()-1).nextTrigger() ) {
			if ( random.nextBoolean() ) {
				rightWallList.add(new Wall("wall3"));
			} else {
				rightWallList.add(new Wall("wall4"));
			}
		}
		if ( !rightWallList.get(0).isVisible() ) {
			rightWallList.remove(0);
			if ( random.nextBoolean() ) {
				rightWallList.add(new Wall("wall3"));
			} else {
				rightWallList.add(new Wall("wall4"));
			}
			if ( Score.getScore()%3 == 0 && sleepTime >= PlayConfig.minSleepTime ) {
				sleepTime--;
			}
			Score.addScore();
		}
		for ( int i = 0; i < rightWallList.size(); i++ ) {
			rightWallList.move();
		}
	}

}
