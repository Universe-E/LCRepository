import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = -1;//声明所有位数字累加和，初始默认为-1
        for (int i = 0; i < nums.length; i++) {
            char[] num = Integer.toString(nums[i]).toCharArray();
            //声明当前数字的位数相加和
            int res = 0;
            for (char c : num) {
                res += c - '0';
            }

            if (map.containsKey(res)) {
                //如果找到位数相加和相同的两个数，则与sum比较，如果较大则更新sum
                sum = Math.max(sum, map.get(res) + nums[i]);
                //如果当前的nums[i]比之前的数要大，则更新一下nums[i]
                if (nums[i] > map.get(res)) map.put(res,nums[i]);
            }
            //否则的话当前res是新值，直接放入map中，并记录首个元素
            else map.put(res,nums[i]);
        }
        return sum;
    }
}
