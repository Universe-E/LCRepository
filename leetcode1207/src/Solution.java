import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> cnt = new HashMap<>();
        for (int i : arr) {
            cnt.put(i,cnt.getOrDefault(i,0)+1);
        }
        HashSet<Integer> set = new HashSet<>();
        for (Integer key : cnt.keySet()) {
            int val = cnt.get(key);
            if (set.contains(val)) return false;
            set.add(val);
        }
        return true;
    }
}