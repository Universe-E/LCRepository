import java.util.ArrayList;

class Solution {
    ArrayList<Integer> pl = new ArrayList<>();
    public boolean primeSubOperation(int[] nums) {
        sieve();
        int n = nums.length,target = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= target) return false;
            //查找使得nums[i]-p > target的最小质数，即查找最大的p < nums[i]-target
            int l = 0, r = pl.size()-1;
            while (l < r) {
                int m = (l+r+1) / 2;
                if (pl.get(m) >= nums[i]-target) r = m-1;
                else l = m;
            }
            if (nums[i] - pl.get(l) > target) nums[i] -= pl.get(l);
            target = nums[i];
        }
        return true;
    }

    //埃氏筛法
    private void sieve() {
        boolean[] flag = new boolean[1001];
        for (int i = 2; i*i <= 1000; i++) {
            if (!flag[i]) {
                for (int j = 2*i; j <= 1000; j += i) {
                    flag[j] = true;
                }
            }
        }
        for (int i = 2; i <= 1000; i++) {
            if (!flag[i]) pl.add(i);
        }
    }
}