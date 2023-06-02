import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        //按照reward1[i]-reward2[i]从大到小排序
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> (o[1] - o[0])));
        for (int i = 0; i < n; i++) {
            pq.add(new int[] {reward1[i],reward2[i],i});
        }
        //第一只从差值最大的开始吃，直到吃够k个，剩下的给第二只吃
        HashSet<Integer> id = new HashSet<>();
        int res = 0;
        for (int i = 0; i < k; i++) {
            int[] c = pq.poll();
            assert c != null;
            res += c[0];
            id.add(c[2]);
        }
        for (int i = 0; i < n; i++) {
            if (!id.contains(i)) res += reward2[i];
        }
        return res;
    }
}