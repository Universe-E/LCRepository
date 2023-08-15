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
            //无法判断哪边有序
            if (nums[l] == nums[mid]) l++;
            //前半部分有序
            else if (nums[l] < nums[mid]) {
                //如果target在[l,mid)之间，则到前半部分找
                if (target >= nums[l] && target < nums[mid]) r = mid - 1;
                //否则到后半部分找
                else l = mid + 1;
            }
            //后半部分有序
            else {
                //如果target在(mid,r]之间，则到后半部分找
                if (target > nums[mid] && target <= nums[r]) l = mid + 1;
                //否则到前半部分找
                else r = mid - 1;
            }
        }
        return false;
    }
}