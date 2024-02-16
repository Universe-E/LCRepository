import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i : arr) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());
        list.sort(Comparator.comparingInt(o->o));
        int res = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (k >= list.get(i)) {
                res--;
                k -= list.get(i);
            }
        }
        return res;
    }
}