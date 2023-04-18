class Solution {
    public int maximumXOR(int[] nums) {
        int[] cnt = new int[32];
        //每个数最多得到当前最大位所在1（即小于等于自身的最大2的幂）
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 32; j++) {
                if ((nums[i] & 1) == 1) cnt[j]++;
                nums[i] >>= 1;
                if (nums[i] == 0) break;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (cnt[i] != 0) res += (int) Math.pow(2,i);
        }
        return res;
    }
}

class Solution2 {
    public int maximumXOR(int[] nums) {
        //本质上是记录所有出现过的1
        int res = 0;
        for (int num : nums) res |= num;
        return res;
    }
}