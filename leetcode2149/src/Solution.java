class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n/2],neg = new int[n/2];
        for (int i = 0,j = 0,k = 0; i < n; i++) {
            if (nums[i] > 0) pos[j++] = nums[i];
            else neg[k++] = nums[i];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i%2==0 ? pos[i/2] : neg[i/2];
        }
        return res;
    }
}