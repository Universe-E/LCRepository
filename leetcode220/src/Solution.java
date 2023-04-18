import java.util.TreeSet;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            //用set就可以，找大于等于左边界的最小值，如果小于等于右边界则符合条件
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            //如果放在前面添加，还要讨论nums[i]本身，因此放在后面添加
            set.add((long) nums[i]);
            //滑动窗口，逐个移除左边界的元素
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}