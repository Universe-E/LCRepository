import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] g = new ArrayList[numCourses];
        Arrays.setAll(g, e->new ArrayList<>());
        int[] inDeg = new int[numCourses];
        for (int[] pre : prerequisites) {
            g[pre[1]].add(pre[0]);
            inDeg[pre[0]]++;//将需要先修课的课程的入度+1
        }
        ArrayList<Integer> list = new ArrayList<>();
        var q = new ArrayDeque<Integer>();
        int cnt = numCourses;
        for (int i = 0; i < numCourses; i++) {
            //添加所有入度为0的点，即不需要先修课的点
            if (inDeg[i] == 0) {
                q.addLast(i);
                list.add(i);
                cnt--;
            }
        }
        while (!q.isEmpty()) {
            int x = q.pollFirst();
            //修完课程x，此时所有需要x作为先修课的课程y的入度-1
            for (Integer y : g[x]) {
                inDeg[y]--;
                if (inDeg[y] == 0) {
                    q.addLast(y);
                    list.add(y);
                    cnt--;
                }
            }
        }
        if (cnt != 0) return new int[]{};
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}