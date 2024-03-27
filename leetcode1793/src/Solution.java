import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length,res = 0, l = k,r = k;
        while (true) {
            //以nums[k]为最小值扩展到边界
            while (r < n && nums[r] >= nums[k]) r++;
            while (l >= 0 && nums[l] >= nums[k]) l--;
            //更新res
            res = Math.max(res,(r-l-1)*nums[k]);
            if (l < 0 && r >= n) break;
            //nums[l]和nums[r]一定都小于nums[k]
            //接下来，nums[k]更新为nums[l]和nums[r]中最大的，然后以这个次大值继续找
            nums[k] = Math.max(l < 0 ? 0 : nums[l],r >= n ? 0 : nums[r]);
        }
        return res;
    }
}

class Solution {
    public int maximumScore(int[] nums, int k) {
        // 可以使用类似贡献度法，枚举每个nums[i]作为最小元素时的最大最数组长度，取min*len最大值即可。
        // 利用单调栈分别向i两侧寻找小于nums[i]第一个位置left和right，[left+1, right-1]就是nums[i]作为最小元素的最长子数组，
        int n = nums.length;
        var q = new ArrayDeque<Integer>();
        //r[i]表示i右侧小于nums[i]的第一数位
        int[] r = new int[n],l = new int[n];
        Arrays.fill(r,n);
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && nums[q.peekFirst()] > nums[i]) r[q.pollFirst()] = i;
            q.addFirst(i);
        }
        q.clear();
        Arrays.fill(l,-1);
        for (int i = n-1;i >= 0;i--) {
            //l[i]表示i左侧小于nums[i]的第一数位
            while (!q.isEmpty() && nums[q.peekFirst()] > nums[i]) l[q.pollFirst()] = i;
            q.addFirst(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (l[i]+1 <= k && r[i]-1 >= k) res = Math.max(res,(r[i]-l[i]-1)*nums[i]);
        }
        return res;
    }
}