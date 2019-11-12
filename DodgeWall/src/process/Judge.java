package process;
import java.awt.Point;
import java.awt.Polygon;

import config.BallConfig;
import config.WallConfig;

public class Judge {
    public static boolean hitJudge (Point ballPoint, Polygon wallPoint) {
    	int ballSize = BallConfig.size;
    	int wallSpeed = WallConfig.yBottomIncrease;
        if ( ballPoint.x != wallPoint.xpoints[WallConfig.buttomLeft] ) { // wallPointの3番目に壁の左下隅の値が入っていました
            return false;
        }
        if ( ballSize > wallSpeed && ( ballPoint.y > wallPoint.ypoints[WallConfig.buttomLeft] || ballPoint.y + 2 * ballSize < wallPoint.ypoints[WallConfig.buttomLeft] ) ) {
            return false;
        }
        if ( ballSize < wallSpeed && ( ballPoint.y > wallPoint.ypoints[WallConfig.buttomLeft] || ballPoint.y + 2 * ballSize < wallPoint.ypoints[WallConfig.buttomLeft] - wallSpeed ) ) {
            return false;
        }
        return true;
    }
}
