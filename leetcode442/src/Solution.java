import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        //由于题目中所有数范围在[1,n]，为避免越界，可以全部减1
        for (int i = 0; i < nums.length; i++) {
            //如果第nums[i]-1位已经是负数，说明nums[i]-1已经出现过一次，此时可以把nums[i]加入到list中
            if (nums[Math.abs(nums[i])-1] < 0) list.add(Math.abs(nums[i]));
            //否则，说明nums[i]-1是第一次出现，将第nums[i]-1位置为负数
            else nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
        }
        return list;
    }
}