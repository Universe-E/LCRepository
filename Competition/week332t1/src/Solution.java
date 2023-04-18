class Solution {
    public long findTheArrayConcVal(int[] nums) {
        int l = 0,r = nums.length-1;
        long res = 0;
        while (l < r) {
            String cur = nums[l] +String.valueOf(nums[r]);
            res += Integer.parseInt(cur);
            l++;
            r--;
        }
        if (l==r) res += nums[l];
        return res;
    }
}