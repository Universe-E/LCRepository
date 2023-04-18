import java.util.HashMap;

class Solution {
    public int countPairs(int[] deliciousness) {
        int[] pows = new int[23];
        //记录可能的所有2的幂
        for (int i = 0; i < pows.length; i++) pows[i] = (int)Math.pow(2,i);
        //用哈希表记录所有的菜品
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int value : deliciousness) map.put(value, map.getOrDefault(value, 0) + 1);
        int m = (int) (1e9+7);
        long res = 0;
        //对每种菜品，如果存在i使得(2^i - k) ∈ map，则将其数量加上去，记为本次组合数量
        for (int value : deliciousness) {
            for (int pow : pows) {
                int k = pow - value;
                if (map.containsKey(k)) {
                    if (k == value) res += map.get(k)-1;
                    else res += map.get(k);
                }
            }
        }
        //注意全部一轮下来，所有的结果恰好重复计算了一次，因此要除2
        return (int) ((res / 2) % m);
    }
}