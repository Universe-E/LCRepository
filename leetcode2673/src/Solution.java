import java.util.ArrayDeque;

class Solution {
    public int minIncrements(int n, int[] cost) {
        int start = (n+1)/2 -1,end = n,res = 0;
        while (start != 0) {
            //自底向上层序遍历
            for (int i = start; i < end; i+=2) {
                //找到每对兄弟节点的最大值，并赋值给父节点
                int l = cost[i],r = cost[i+1];
                res += Math.abs(l-r);
                cost[i/2] += Math.max(l,r);
            }
            end = start;
            start = (start+1)/2 - 1;
        }
        return res;
    }
}