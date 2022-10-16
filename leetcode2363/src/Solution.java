import java.util.*;

class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer,Integer> map = new TreeMap<>();
        for (int[] ints : items1) {
            map.put(ints[0], ints[1]);
        }
        for (int[] ints : items2) {
            if (!map.containsKey(ints[0])) map.put(ints[0],ints[1]);
            else {
                int weight = map.get(ints[0]);
                map.put(ints[0],weight + ints[1]);
            }
        }
        List<List<Integer>> resList = new ArrayList<>();
        Integer[] keys = new Integer[map.size()];
        map.keySet().toArray(keys);
        Arrays.sort(keys);
        for (int key : keys) {
            List<Integer> curList = new ArrayList<>();
            curList.add(key);
            curList.add(map.get(key));
            resList.add(curList);
        }
        return resList;
    }
}
