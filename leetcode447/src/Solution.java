import java.util.HashMap;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (j==i) continue;
                int d = (int) (Math.pow(Math.abs(points[i][0]-points[j][0]),2)+Math.pow(Math.abs(points[i][1]-points[j][1]),2));
                map.put(d,map.getOrDefault(d,0)+1);
            }
            for (Integer k : map.keySet()) {
                res += map.get(k)*(map.get(k)-1);
            }
        }
        return res;
    }
}