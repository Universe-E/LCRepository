class Solution {
    public int minMaxGame(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] oldNums = nums,newNums = new int[0];
        while (n != 1) {
            newNums = new int[n/2];
            for (int i = 0; i < n/2; i++) {
                if ((i&1) == 0) newNums[i] = Math.min(oldNums[i<<1],oldNums[(i<<1)+1]);
                else newNums[i] = Math.max(oldNums[i<<1],oldNums[(i<<1)+1]);
            }
            oldNums = newNums;
            n /= 2;
        }
        return newNums[0];
    }
}