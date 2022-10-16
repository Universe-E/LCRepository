class Solution2 {
    //交换律：a ^ b ^ c <=> a ^ c ^ b
    //任何数于0异或为任何数 0 ^ n => n
    //相同的数异或为0: n ^ n => 0
    //不需要额外空间的方法，就往位运算上想
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }
}
