import java.util.ArrayList;
import java.util.List;

class CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    public int f(int x, int y);
};


class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        int x = 1, y = 1000;
        while (x <= 1000 && y >= 1) {
            if (customfunction.f(x,y) == z) {
                List<Integer> l = new ArrayList<>();
                l.add(x);
                l.add(y);
                res.add(l);
                //注意每次要更新x
                x++;
            }
            else if (customfunction.f(x,y) > z) y--;
            else x++;
        }
        return res;
    }
}