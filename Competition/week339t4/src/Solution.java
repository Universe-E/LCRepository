import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

class Solution {
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        //无法翻转的情况
        if (k == 1) {
            ans[p] = 0;
            return ans;
        }
        //将被ban的位置放入banSet中
        HashSet<Integer> banSet = new HashSet<>();
        for (int ban : banned) {
            banSet.add(ban);
        }
        //按奇偶记录两个set
        TreeSet<Integer>[] sets = new TreeSet[2];
        Arrays.setAll(sets,e -> new TreeSet<>());
        for (int i = 0; i < n; i++) {
            //跳过p，以及被ban的位置
            if (i != p && !banSet.contains(i)) sets[i%2].add(i);
        }

        //接下来bfs
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addLast(p);
        ans[p] = 0;
        while (!q.isEmpty()) {
            int cur = q.pollFirst();
            //计算跳跃范围
            int l = Math.max(-(k-1),k-1-cur*2), r = Math.min(k-1,-(k-1) + (n-cur-1)*2);
            // 寻找第一个大于等于cur+l的位置，并开始枚举后面连续的位置
            //x表示当前位置的奇偶性
            int x = (cur+(k-1))%2;
            Integer it = sets[x].ceiling(cur+l);
            for (Integer num : sets[x]) {
                //从第一个大于cur+l的位置开始
                if (num <= it) continue;
                //遇到第一个大于cur+r的位置为止
                if (num > cur+r) break;

            }
        }


    }
}