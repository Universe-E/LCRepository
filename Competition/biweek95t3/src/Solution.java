class Solution {
    public int xorBeauty(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int val = (nums[i]|nums[j])&nums[k];
                    res ^= val;
                }
            }
        }
        int p = 0;
        for (int i = 0; i < n; i++) {
            p ^= nums[i];
        }
        System.out.println(p);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {15,45,20,2,34,35,5,44,32,30};
        System.out.println("答案：" +new Solution().xorBeauty(nums));
    }
}