import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

class Solution {
    // f_g.get(i)是一个list，list是i的互质数(1-50范围),其实就是一个图
    List<List<Integer>> f_g = new LinkedList<>();
    // 结果矩阵
    int[] res;
    // 题目中给定的树/图
    List<List<Integer>> G = new ArrayList<>();
    int n;
    int[] nums;
    /*
     * 大佬代码中的pair
     * val_level[i] ：值为i的元素出现的level
     * idx[i] : 值为i的元素作为最近父亲出现的点的索引值
     * */
    int[] val_level = new int[51];
    int[] idx = new int[51];


    public int[] getCoprimes(int[] nums, int[][] edges) {
        this.nums = nums;
        res = new int[nums.length];
        Arrays.fill(res, -1);
        // 默认不出现
        Arrays.fill(idx, -1);
        n = nums.length;
        // 建图开始
        for (int i = 0; i < 51; i++) {
            f_g.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            G.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            G.get(edge[0]).add(edge[1]);
            G.get(edge[1]).add(edge[0]);
        }
        for (int i = 1; i < 51; i++) {
            for (int j = i; j < 51; j++) {
                if (gcd(i, j) == 1) {
                    f_g.get(i).add(j);
                    f_g.get(j).add(i);
                }
            }
        }
        // 建图结束
        dfs(0, -1, 1);
        return res;
    }

    public void dfs(int cur, int pre, int level) {
        int val = nums[cur];
        int latest_level = 0;
        int latest_val = -1;
        for (int maybe : f_g.get(val)) {
            if (val_level[maybe] > latest_level) {
                latest_level = val_level[maybe];
                latest_val = maybe;
            }
        }
        res[cur] = (latest_val == -1) ? -1 : idx[latest_val];
        // 下面的实现和大佬的不一样，我采用了系统栈保存结果，大佬用的显式栈
        int origin_level = val_level[val];
        int origin_idx = idx[val];
        val_level[val] = level;
        idx[val] = cur;
        for (int next : G.get(cur)) {
            if (next != pre) {
                dfs(next, cur, level + 1);
            }
        }
        val_level[val] = origin_level;
        idx[val] = origin_idx;
    }
    // 网上百度的gcd算法
    public int gcd(int m, int n) {
        if (m < n) {
            int k = m;
            m = n;
            n = k;
        }
        return m % n == 0 ? n : gcd(n, m % n);
    }
}