import java.util.TreeMap;

class Solution {
    public int minimumSum(int[] nums) {
        int res = Integer.MAX_VALUE;
        TreeMap<Integer,Integer> left = new TreeMap<>(),right = new TreeMap<>();
        for (int num : nums) {
            right.put(num,right.getOrDefault(num,0)+1);
        }
        for (int num : nums) {
            right.put(num, right.get(num) - 1);
            if (right.get(num) == 0) right.remove(num);
            if (!left.keySet().isEmpty() && !right.keySet().isEmpty()) {
                int l = left.firstKey(), r = right.firstKey();
                if (num > l && num > r) res = Math.min(res, l + num + r);
            }
            left.put(num, left.getOrDefault(num, 0) + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}