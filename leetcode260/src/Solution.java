class Solution {
    public int[] singleNumber(int[] nums) {
        int nums1 = 0,nums2 = 0;
        int xor = 0;
        //当前结果xor等同于数组中两个只出现一次的数字按位异或的结果
        for (int num : nums) xor ^= num;
        //接下来，找到该数字最右边的非0数位
        //方法为：xor与1（即二进制0000 0000 0000 0000 0000 0000 0000 0001）不断按位异或，若结果不等于0则该数位非0
        //最终第一个非0数位存储在bit中
        int bit = 1;
        while ((xor & 1) == 0) {
            xor >>= 1;
            bit <<= 1;
        }
        //接下来，将数组分为2组，一组与当前数位按位与结果为1（即该数位为1），另一组按位与结果为0（即该数位为0）
        for (int num : nums) {
            if ((num & bit) == 0) nums1 ^= num;
            else nums2 ^= num;
        }
        return new int[] {nums1,nums2};
    }
}