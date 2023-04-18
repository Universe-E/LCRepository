import java.util.HashMap;

class Solution {
    public long countGood(int[] nums, int k) {
        long res = 0,cur = 0;
        HashMap<Integer,Integer> g = new HashMap<>();
        int i = 0;
        for (int num : nums) {
            //cur的自增要写在添加元素前面，原因如下：
            //如果num和map中的key不重复，则cur一直是0，直到map中已经存在num时cur才会增加
            cur += g.getOrDefault(num, 0);
            g.put(num, g.getOrDefault(num, 0) + 1);
            //滑动窗口，对于每一个num,向右找到第一个不满足条件的左边界i
            while (cur >= k) {
                //put返回的是修改前的值
                //也可以写成cur -= g.put(nums[i],g.get(nums[i])-1)-1;
                g.put(nums[i], g.get(nums[i]) - 1);
                cur -= g.get(nums[i]);
                i++;
            }
            //不管是否进入while循环,在[0,i-1]区间为左边界的子数组一定符合条件，因为i是第一个不符合条件的左边界
            res += i;
        }
        return res;
    }
}