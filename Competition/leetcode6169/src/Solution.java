class Solution {
    public int longestNiceSubarray(int[] nums) {
        int res = 0;//or作为按位或的变量
        for (int i = 0; i < nums.length; i++) {
            int j = i,or = 0;
            //如果存在两两按位与结果为0，则当前值与所有值按位或的结果也应为0，即二进制结果不存在重复的1
            while (j >= 0 && (nums[j] & or) == 0) {
                or = or | nums[j];//每一次让or和当前值按位或
                j--;
            }
            res = Math.max(res,i - j);
        }
        return res;
    }
}
