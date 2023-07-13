import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int max = 1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : arr) {
            int value = num - difference;
            map.put(num,map.getOrDefault(value,0) + 1);
            max = Math.max(max, map.get(num));
        }
        return max;
    }
}
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int res = 1;
        var map = new HashMap<Integer,Integer>();
        for (int num : arr) {
            int pre = num - difference;
            if (map.containsKey(pre)) map.put(num, map.get(pre) + 1);
            else map.put(num, 1);
            res = Math.max(res, map.get(num));
        }
        return res;
    }
}