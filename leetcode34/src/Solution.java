class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = 0,r = n - 1;
        int left = -1,right = -1;
        boolean containsLeft = false,containsRight = false;
        //找到左边界
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) l = mid + 1;
            else if (nums[mid] > target) r = mid - 1;
            else {
                r = mid;
                containsLeft = true;
                if (l == r) break;
            }
        }
        if (containsLeft) left = r;
        l = 0;
        r = n - 1;
        //找到右边界
        while (l <= r) {
            int mid = (l + r + 1) / 2;
            if (nums[mid] < target) l = mid + 1;
            else if (nums[mid] > target) r = mid - 1;
            else {
                l = mid;
                containsRight = true;
                if (l == r) break;
            }
        }
        if (containsRight) right = l;
        return new int[] {left, right};
    }
}