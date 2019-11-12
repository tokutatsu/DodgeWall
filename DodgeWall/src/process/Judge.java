package process;
import java.awt.*;

public class Judge {
    public static boolean hitJudge (Point ballPoint, int ballSize, Polygon wallPoint, int wallSpeed) { // ballSizeとwallSpeedは今後configから持ってくる
        if ( ballPoint.x != wallPoint.xpoints[3] ) { // wallPointの4番目に壁の左下隅の値が入っているものとして考えている
            return false;
        }
        if ( ballSize > wallSpeed && ( ballPoint.y > wallPoint.ypoints[3] || ballPoint.y + 2 * ballSize < wallPoint.ypoints[3] ) ) {
            return false;
        }
        if ( ballSize < wallSpeed && ( ballPoint.y > wallPoint.ypoints[3] || ballPoint.y + 2 * ballSize < wallPoint.ypoints[3] - wallSpeed ) ) {
            return false;
        }
        return true;
    }
}