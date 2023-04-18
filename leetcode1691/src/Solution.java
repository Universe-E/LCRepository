import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length;
        //sort each cuboid array
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }
        //sort subsequently from arr[0] to arr[2]
        Arrays.sort(cuboids, (o1,o2) -> (o1[0]==o2[0] ? (o1[1]==o2[1] ? o2[2]-o1[2] : o2[1]-o1[1]) : o2[0]-o1[0]));
        int[] res = new int[n];
        //res[i] represents the possible tallest height from 0 to i
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (cuboids[j][1] >= cuboids[i][1] && cuboids[j][2] >= cuboids[i][2]) res[i] = Math.max(res[i],res[j]);
            }
            res[i] += cuboids[i][2];
        }
        int ans = 0;
        for (int re : res) {
            ans = Math.max(ans, re);
        }
        return ans;
    }
}