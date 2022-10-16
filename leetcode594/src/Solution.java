import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int cur = nums[i],times = 0;
            while (i < nums.length && nums[i] == cur) {
                times++;
                i++;
            }
            list.add(new int[] {times,cur});
        }
        int res = 0;
        for (int j = 0; j < list.size() - 1; j++) {
            if (list.get(j + 1)[1] - list.get(j)[1] == 1) res = Math.max(res,list.get(j)[0] + list.get(j + 1)[0]);
        }
        return res;
    }
}
