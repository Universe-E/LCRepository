import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <= 9; i++) {
            dfs(i,n);
        }
        return list;
    }

    private void dfs(int cur,int n) {
        if (cur > n) return;
        list.add(cur);
        for (int i = 0; i < 10; i++) {
            dfs(10 * cur + i,n);
        }
    }
}

class Solution2 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        int num = 1;
        for (int i = 1; i <= n; i++) {
            list.add(num);
            if (num * 10 <= n) {
                num *= 10;
            }
            else {
                while (num % 10 == 9 || num == n) num /= 10;
                num++;
            }
        }
        return list;
    }
}