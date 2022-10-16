import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int transportationHub(int[][] path) {
        //记录所有的起点和重点
        HashSet<Integer> src = new HashSet<>();
        HashSet<Integer> dest = new HashSet<>();
        HashSet<Integer> all = new HashSet<>();
        for (int[] ints : path) {
            src.add(ints[0]);
            dest.add(ints[1]);
            all.add(ints[0]);
            all.add(ints[1]);
        }
        for (Integer num : dest) {
            //交通枢纽不能作为起点
            if (src.contains(num)) continue;
            //从所有点中移除当前num作为当前集合
            HashSet<Integer> cur = new HashSet<>(all);
            cur.remove(num);
            for (int[] ints : path) {
                if (ints[1] == num) {
                    cur.remove(ints[0]);
                }
            }
            if (cur.size() == 0) return num;
        }
        return -1;
    }
}