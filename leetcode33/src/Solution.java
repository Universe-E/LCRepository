class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length,l0 = 0,r0 = n-1;
        //find the smallest index
        while (l0 < r0) {
            int m = (l0+r0)/2;
            if (nums[m] < nums[r0]) r0 = m;
            else l0 = m+1;
        }
        int diff = l0,l1 = 0,r1 = n-1;
        while (l1 <= r1) {
            int m = (l1+r1)/2;
            int cur = nums[(m+diff)%n];
            if (cur == target) return (m+diff)%n;
            else if (cur > target) r1 = m-1;
            else l1 = m+1;
        }
        return -1;
    }
}