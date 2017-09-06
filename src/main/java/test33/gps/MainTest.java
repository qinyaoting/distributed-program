package test33.gps;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 9/5/17
 * Time: 6:23 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class MainTest {

    public static void main(String[] args) {

        //double db = GpsUtil.distLawOfCosinesRAD(39.941,116.45,39.94,116.451);
        //double db = SpatialUtils.distance(39.941,116.45,39.94,116.451,"K");
        double db =DistanceUtil.distanceSimplify(39.941,116.45,39.94,116.451);
        System.out.println(db);

        // 0.14010978285177497
    }
}
