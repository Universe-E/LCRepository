import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        var q = new ArrayDeque<Integer>();
        q.addLast(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == q.peekLast()) continue;
            q.addLast(nums[i]);
        }
        q.addFirst(0);
        q.addLast(0);
        ArrayList<Integer> list = new ArrayList<>(q);
        long pos = 0,neg = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            int cur = list.get(i);
            if (cur > list.get(i-1) && cur > list.get(i+1)) pos += cur;
            else if (cur < list.get(i-1) && cur < list.get(i+1)) neg += cur;
        }
        return pos-neg;
    }
}

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[nums.length + 2];
        System.arraycopy(nums, 0, tmp, 1, n);
        boolean plus = true;
        long res = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (plus) {
                if (tmp[i-1] <= tmp[i] && tmp[i] > tmp[i+1]) {
                    res += tmp[i];
                    plus = false;
                }
            } else {
                if (tmp[i-1] >= tmp[i] && tmp[i] < tmp[i+1]) {
                    res -= tmp[i];
                    plus = true;
                }
            }
        }
        return res;
    }
}