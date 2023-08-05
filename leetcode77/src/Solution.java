import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTrack(n,k,1,cur);
        return res;
    }

    private void backTrack(int n,int k,int start,List<Integer> cur) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));//注意必须新建ArrayList，否则是空数组
            return;
        }
        for (int i = start; i <= n; i++) {
            cur.add(i);
            backTrack(n,k,i + 1,cur);
            cur.remove(cur.size() - 1);
        }
    }
}

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTrack(n,k,1,new ArrayList<>());
        return res;
    }

    private void backTrack(int n,int k,int start,List<Integer> cur) {
        if (k == 0) {
            res.add(new ArrayList<>(cur));//注意必须新建ArrayList，否则后续的remove操作，又将res中cur的元素删除了
            return;
        }
        for (int i = start; i <= n; i++) {
            cur.add(i);
            backTrack(n,k-1,i + 1,cur);
            cur.remove(cur.size() - 1);
        }
    }
}