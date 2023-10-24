import java.util.HashMap;

class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int mul = nums[i]*nums[j];
                map.put(mul,map.getOrDefault(mul,0)+1);
            }
        }
        int res = 0;
        for (Integer k : map.keySet()) {
            int v = map.get(k);
            res += v*(v-1)/2*8;
        }
        return res;
    }
}