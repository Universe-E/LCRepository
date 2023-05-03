import java.util.Arrays;
import java.util.HashMap;

class Solution {
    //问题转化为“每个元素前面比它大的元素个数之和”
    public long countOperationsToEmptyArray(int[] nums) {
        int n = nums.length;
        int[] temp = Arrays.copyOf(nums, n);
        Arrays.sort(temp);
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(temp[i],i);
        }
        //
        long res = 0,cnt = 0;
        for (int i = 0; i < n; i++) {

        }
    }
}