import java.util.*;

class Solution {
    public int minGroups(int[][] intervals) {
        TreeSet<int[]> set = new TreeSet<>((o1,o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        set.addAll(Arrays.asList(intervals));
        List<List<int[]>> lists = new ArrayList<>();
        for (int[] ints : set) {
            if (lists.size() == 0) {
                List<int[]> list = new ArrayList<>();
                list.add(ints);
                lists.add(list);
            }
            else {
                boolean isAdded = false;
                for (List<int[]> list : lists) {
                    if (list.get(list.size() - 1)[1] < ints[0]) {
                        list.add(ints);
                        isAdded = true;
                        break;
                    }
                }
                if (!isAdded) {
                    List<int[]> list = new ArrayList<>();
                    list.add(ints);
                    lists.add(list);
                }
            }
            lists.sort(Comparator.comparingInt(o -> o.get(o.size() - 1)[1]));
        }
        return lists.size();
    }
}