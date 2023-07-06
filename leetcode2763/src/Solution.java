import java.util.Arrays;

class Solution {
    public int sumImbalanceNumbers(int[] nums) {
        int n = nums.length,res = 0;
        boolean[] v = new boolean[n+2];
        for (int i = 0; i < n-1; i++) {
            Arrays.fill(v,false);
            v[nums[i]] = true;
            int cnt = 0;
            for (int j = i+1; j < n; j++) {
                int x = nums[j];
                //如果nums[j]出现过，则排序后必定有相邻元素，此时cnt不变
                if (!v[x]) {
                    //如果nums[j]没出现过，则看nums[j]-1和nums[j]+1是否出现过
                    v[x] = true;
                    cnt++;
                    if (v[x-1]) cnt--;//x和x-1是“平衡的”
                    if (v[x+1]) cnt--;//x和x+1是“平衡的”
                }
                res += cnt;
            }
        }
        return res;
    }
}