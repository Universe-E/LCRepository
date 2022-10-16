import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer,String> map = new TreeMap<>((o1, o2) -> o2 - o1);
        int n = names.length;
        for (int i = 0; i < n; i++) {
            map.put(heights[i],names[i]);
        }
        List<String> list = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            list.add(map.get(integer));
        }
        return list.toArray(new String[map.size()]);
    }
}