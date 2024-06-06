import java.util.TreeMap;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;
        int groups = n / groupSize;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int h : hand) {
            map.put(h,map.getOrDefault(h,0)+1);
        }
        for (int i = 0; i < groups; i++) {
            int first = map.firstKey();
            for (int j = 0; j < groupSize; j++) {
                if (!map.containsKey(first + j)) return false;
                int key = first + j;
                map.put(key,map.get(key)-1);
                if (map.get(key) == 0) map.remove(key);
            }
        }
        return map.keySet().isEmpty();

    }
}