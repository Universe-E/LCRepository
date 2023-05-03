import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> sx = new HashSet<>(), sy = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        if (x == 1 && y == 1) {
            sx.add(1);
            sy.add(1);
        }
        else if (x == 1) {
            sx.add(1);
            int ys = 1;
            while (ys < bound) {
                sy.add(ys);
                ys *= y;
            }
        }
        else if (y == 1) {
            sy.add(1);
            int xs = 1;
            while (xs < bound) {
                sx.add(xs);
                xs *= x;
            }
        }
        else {
            int xs = 1, ys = 1;
            while (xs < bound || ys < bound) {
                if (xs < bound) {
                    sx.add(xs);
                    xs *= x;
                }
                if (ys < bound) {
                    sy.add(ys);
                    ys *= y;
                }
            }
        }
        for (Integer xx : sx) {
            for (Integer yy : sy) {
                int cur = xx + yy;
                if (cur <= bound)res.add(cur);
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {2,4,389260,10,2188,389020,154,28,566164,389018,391204,6562,5410,802,389026,59050,6058,19756,531514,25012,316,395578,5572,448066,177220,536770,74,76,182476,82,5330,5332,2260,730,5338,7516,19684,100,6634,5356,389098,11890,59122,244,389746,531442,64378,408700,177148};
        int[] arr2 = new int[] {2,4,10,2188,448066,389018,566164,5572,154,28,5338,6562,391204,389020,59050,5410,19756,59122,25012,389260,389044,531514,316,536770,177220,182476,74,76,802,82,2260,11890,19684,730,7516,395578,100,408700,6634,5356,5330,389098,531442,244,389746,5332,64378,177148,6058,389026};
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}