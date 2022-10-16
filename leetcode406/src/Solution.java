import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //按身高从高到低排，如果身高相同按k从小到大排
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        });
        LinkedList<int[]> list = new LinkedList<>();
        //每次向链表的第k个位置添加节点
        for (int[] person : people) {
            list.add(person[1],person);
        }
        return list.toArray(new int[list.size()][]);
    }
}