class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0,r = nums.length - 1;
        if (nums[0] > target) return 0;
        if (nums[nums.length - 1] < target) return nums.length;
        while (l <= r){
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                if (nums[mid - 1] < target) return mid;
                r = mid;
            }
            else {//nums[mid] < target
                if (nums[mid + 1] > target) return mid + 1;
                l = mid + 1;
            }
        }
        return -1;
    }
}
