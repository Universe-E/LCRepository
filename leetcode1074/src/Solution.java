import java.util.HashMap;

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length,n = matrix[0].length, res = 0;
        for (int i = 0; i < m; i++) {// enumerate upper bound
            int[] sum = new int[n];
            for (int j = i; j < m; j++) {//enumerate lower bound
                for (int k = 0; k < n; k++) {// renew sum of column in range of [i,j]
                    sum[k] += matrix[j][k];
                }
                res += sub(sum,target);
            }
        }
        return res;
    }

    private int sub(int[] sum,int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int cnt = 0, pre = 0;
        for (int i : sum) {
            pre += i;
            if (map.containsKey(pre-target)) cnt += map.get(pre-target);
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return cnt;
    }
}