import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        //incr表示第i位（包含第i位）之前连续递减的个数，decr表示第i位（包括第i位）之后连续递增的个数
        int[] incr = new int[n],decr = new int[n];
        //每个数本身也可以作为1位，所以初始值都是1
        Arrays.fill(incr,1);
        Arrays.fill(decr, 1);
        //例如：nums = [2,1,1,1,3,4,1]
        //incr[] =    [1,2,3,4,1,1,2]
        //decr[] =    [1,5,4,3,2,1,1]
        //对于incr[]数组，如果nums[i]不大于nums[i - 1]，则满足条件，否则直接跳过
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) incr[i] = incr[i - 1] + 1;
        }
        //同理对于decr[]数组，nums[i]不大于nums[i + 1]
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) decr[i] = decr[i + 1] + 1;
        }
        List<Integer> res = new ArrayList<>();
        //对于i，需要满足incr[i - 1]的值比k大，且decr[i + 1]的值也比k大
        for (int i = k; i < n - k; i++) {
            if (incr[i - 1] >= k && decr[i + 1] >= k) res.add(i);
        }
        return res;
    }
}