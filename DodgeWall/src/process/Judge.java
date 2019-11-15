package process;
import config.BallConfig;
import config.WallConfig;
import unit.Ball;
import unit.Wall;

public class Judge {
    public static boolean hitJudge (Ball ball, Wall wall) {
    	int ballSize = BallConfig.size;
    	int wallSpeed = WallConfig.yBottomIncrease;
        if ( ! wall.getName().endsWith(Integer.toString(ball.getPosition())) ) {
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
