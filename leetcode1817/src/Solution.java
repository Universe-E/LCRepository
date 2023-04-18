import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans = new int[k];
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            HashSet<Integer> set = map.getOrDefault(log[0],new HashSet<>());
            set.add(log[1]);
            map.put(log[0],set);
        }
        for (Integer key : map.keySet()) {
            ans[map.get(key).size()-1]++;
        }
        return ans;
    }
}