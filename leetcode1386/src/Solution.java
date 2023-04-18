import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] seat : reservedSeats) {
            if (!map.containsKey(seat[0])) {
                map.put(seat[0], new ArrayList<>());
            }
            map.get(seat[0]).add(seat[1]);
        }
        int oc = 0;
        for (Integer key : map.keySet()) {
            oc += getCnt(map.get(key));
        }
        return 2*(n-map.size()) + oc;
    }

    private int getCnt(List<Integer> list) {
        boolean left = true,right = true, mid = true;
        for (Integer id : list) {
            if (id >= 2 && id <= 5) left = false;
            if (id >= 6 && id <= 9) right = false;
            if (id >= 4 && id <= 7) mid = false;
        }
        if (left && right) return 2;
        if (!left && !right) return mid ? 1 : 0;
        return 1;
    }
}