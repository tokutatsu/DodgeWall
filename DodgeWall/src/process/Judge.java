package process;
import java.util.ArrayList;

import config.BallConfig;
import config.WallConfig;
import unit.Ball;
import unit.Wall;

public class Judge {

	public static boolean hitJudge(Ball leftBall, ArrayList<Wall> leftWallList, Ball rightBall, ArrayList<Wall> rightWallList) {
		return checkAllWall(leftBall, leftWallList) || checkAllWall(rightBall, rightWallList);
	}

	private static boolean checkAllWall(Ball ball, ArrayList<Wall> wallList) {
		for ( int i = 0; i < wallList.size(); i++ ) {
			if ( Judge.checkEachWall(ball, wallList.get(i)) ) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkEachWall(Ball ball, Wall wall) {
		int ballSize = BallConfig.size;
		int wallSpeed = WallConfig.yBottomIncrease;
		if ( wall.getPosition() != ball.getPosition() ) {
			return false;
		}
		if ( ballSize > wallSpeed && ( ball.getPoint().y + ballSize / 2 > wall.getButtomLeft() || ball.getPoint().y + ballSize < wall.getButtomLeft() ) ) {
			return false;
		}
		if ( ballSize < wallSpeed && ( ball.getPoint().y + ballSize / 2 > wall.getButtomLeft() || ball.getPoint().y + ballSize < wall.getButtomLeft() - wallSpeed ) ) {
			return false;
		}
		return true;
	}
}
