import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }
        timePoints.sort((o1,o2) -> {
            int h1 = Integer.parseInt(o1.substring(0,2)), m1 = Integer.parseInt(o1.substring(3));
            int h2 = Integer.parseInt(o2.substring(0,2)), m2 = Integer.parseInt(o2.substring(3));
            if (h1 == h2) return m1-m2;
            else return h1-h2;
        });
        int n = timePoints.size(), res = 0x3f3f3f3f;
        for (int i = 0; i < n; i++) {
            String t1 = timePoints.get(i), t2 = timePoints.get((i+1)%n);
            int h1 = Integer.parseInt(t1.substring(0,2)), m1 = Integer.parseInt(t1.substring(3));
            int h2 = Integer.parseInt(t2.substring(0,2)), m2 = Integer.parseInt(t2.substring(3));
            if (i == n-1) res = Math.min(res,60 * (h2+24-h1) + m2-m1);
            else res = Math.min(res,60 * (h2-h1) + m2-m1);
        }
        return res;
    }
}