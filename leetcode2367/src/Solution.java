import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> list = new ArrayList<>();
    public int arithmeticTriplets(int[] nums, int diff) {
        for (int num : nums) list.add(num);
        int res = 0;
        for (int i = 0; i < list.size(); i++)
            if (list.contains(nums[i] + diff) && list.contains(nums[i] + 2 * diff))
                res++;
        return res;
    }
}
