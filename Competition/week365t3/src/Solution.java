class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        int n = nums.length;
        //数组求和
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //得到target与sum的余数m，多余长度可用n*m填补
        int m = (int) ((long) target/sum);
        //如果target大于数组之和sum，则考察target%sum即可
        int t = (int) ((long) target%sum);

        //滑动窗口分2中情况：
        //1.target是窗口内元素和，此时最短长度len = min(r-l+1)
        //2.target是窗口外元素和，此时最短长度len = min(n-(r-l+1))
        long total1 = 0,total2 = 0;
        int len1 = n+1,len2 = n+1;
        for (int r = 0,l1 = 0,l2 = 0; r < n; r++) {
            total1 += nums[r];
            total2 += nums[r];
            while (total1 > t) total1 -= nums[l1++];
            while (total2 > sum-t) total2 -= nums[l2++];
            if (total1 == t) len1 = Math.min(len1,r-l1+1);
            if (total2 == sum-t) len2 = Math.min(len2,n-(r-l2+1));
        }
        //如果2中情况均未找到等于target的情况，返回-1
        if (len1 == n+1 && len2 == n+1) return -1;
        return m*n + Math.min(len1,len2);
    }
}