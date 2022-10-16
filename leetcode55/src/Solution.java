class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != 0 && temp[i] == 0) return false;
            for (int j = i + 1; j < Math.min(i + nums[i] + 1,n); j++) {
                if (temp[j] == 1) continue;
                temp[j] = 1;
            }
        }
        return temp[n - 1] == 1;
    }
}

class Solution2 {
    public boolean canJump(int[] nums) {
        int k = 0;//k表示能跳到的最远距离
        for (int i = 0; i < nums.length; i++) {
            if (i > k) return false;
            k = Math.max(k,nums[i] + i);
        }
        return true;
    }
}