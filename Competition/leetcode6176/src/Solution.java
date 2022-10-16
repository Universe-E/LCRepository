import java.util.*;

class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                if (!map.containsKey(num)) map.put(num,1);
                else map.put(num,map.get(num) + 1);
            }
        }
        if (map.size() == 0) return -1;
        List<int[]> list = new ArrayList<>();
        for (Integer i : map.keySet()) {
            list.add(new int[] {i,map.get(i)});
        }
        list.sort((o1, o2) -> {
            if (o1[1] != o2[1]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        });
        return list.get(list.size() - 1)[0];
    }
}
