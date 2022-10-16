import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public long countBadPairs(int[] nums) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = nums[i] - i;
        }
        HashMap<Integer, Long> map = new HashMap<>();
        for (int num : temp) {
            if (!map.containsKey(num)) map.put(num, 1L);
            else {
                long value = map.get(num);
                map.put(num, value + 1);
            }
        }
        //注意，这里直接相乘会整型溢出，因此要转成长整型
        long res = (long) nums.length * (nums.length - 1) / 2;
        for (Integer i : map.keySet()) {
            long value = map.get(i);
            res -= value * (value - 1) / 2;
        }
        return res;
    }
}
