import java.util.Random;

class Solution {

    Random random;
    double x, y, r;
    public Solution(double radius, double x_center, double y_center) {
        random = new Random();
        x = x_center;
        y = y_center;
        r = radius;
    }

    public double[] randPoint() {

        double distance,rx,ry;
        //注意不能在[0,r]直接随机取点，因为[0,r/2]扫过的面积小于[r/2,r]扫过的面积
        double len = Math.sqrt(r * r * Math.random()), ang = 2 * Math.PI * Math.random();

        double randomX = x + len * Math.cos(ang);
        double randomY = y + len * Math.sin(ang);
        return new double[] {randomX,randomY};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */