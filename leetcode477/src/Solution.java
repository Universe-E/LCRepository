class Solution {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        //对于每一个二进制位，分别得到0的个数和1的个数，则当前位数的不同数目是0的个数 * 1的个数
        int n = nums.length;
        for (int i = 0; i < 30; i++) {
            int zero = 0,one = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) one++;
                else zero++;
            }
            res += one * zero;
        }
        return res;
    }
}