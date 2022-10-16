class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return false;
        if (n == 1) return nums[0] == target;
        int l = 0,r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            System.out.println(mid);
            if (nums[mid] == target) return true;
            if (nums[l] == nums[mid]) l++;
            else if (nums[l] < nums[mid]) {
                if (target >= nums[l] && target < nums[mid]) r = mid - 1;
                else l = mid + 1;
            }
            else {
                if (target > nums[mid] && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return false;
    }
}