import java.util.HashMap;

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