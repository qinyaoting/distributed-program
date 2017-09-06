package test33.gps;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 9/5/17
 * Time: 6:44 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class DistanceUtil {

    public static double distanceSimplify(double lat1, double lng1, double lat2, double lng2) {
        double dx = lng1 - lng2; // 经度差值
        double dy = lat1 - lat2; // 纬度差值
        double b = (lat1 + lat2) / 2.0; // 平均纬度
        double Lx = Math.toRadians(dx) * 6367000.0* Math.cos(Math.toRadians(b)); // 东西距离
        double Ly = 6367000.0 * Math.toRadians(dy); // 南北距离
        return Math.sqrt(Lx * Lx + Ly * Ly);  // 用平面的矩形对角距离公式计算总距离
    }
}
