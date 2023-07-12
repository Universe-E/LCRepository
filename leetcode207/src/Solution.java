import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] g = new ArrayList[numCourses];
        Arrays.setAll(g,e->new ArrayList<>());
        int[] inDeg = new int[numCourses];
        for (int[] pre : prerequisites) {
            g[pre[1]].add(pre[0]);
            inDeg[pre[0]]++;//将需要先修课的课程的入度+1
        }
        var q = new ArrayDeque<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0) q.addLast(i);//添加所有入度为0的点，即不需要先修课的点
        }
        while (!q.isEmpty()) {
            int x = q.pollFirst();
            //修完课程x，此时所有需要x作为先修课的课程y的入度-1
            for (Integer y : g[x]) {
                inDeg[y]--;
                if (inDeg[y] == 0) q.addLast(y);
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] != 0) return false;
        }
        return true;
    }
}