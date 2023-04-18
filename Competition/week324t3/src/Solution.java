import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        ArrayList<Integer>[] g = new ArrayList[n+1];
        ArrayList<Integer> oddList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (List<Integer> edge : edges) {
            int x = edge.get(0), y = edge.get(1);
            g[x].add(y);
            g[y].add(x);
        }
        //判断当前点是否为奇数条边
        for (int i = 1; i <= n; i++) {
            if (g[i].size() % 2 == 1) {
                oddList.add(i);
            }
        }
        int sz = oddList.size();
        if (sz == 0) return true;
        if (sz == 1 || sz == 3 || sz > 4) return false;
        if (sz == 2) {
            int x = oddList.get(0), y = oddList.get(1);
            if (!isConnected(x,y,g)) return true;
            for (int i = 1; i <= n; i++) {
                if (i == x || i == y) continue;
                if (!isConnected(i,x,g) && !isConnected(i,y,g)) return true;
            }
            return false;
        }
        //sz == 4的情况
        int a = oddList.get(0), b = oddList.get(1), c = oddList.get(2), d = oddList.get(3);
        if (!isConnected(a,b,g) && !isConnected(c,d,g)) return true;
        if (!isConnected(a,c,g) && !isConnected(b,d,g)) return true;
        if (!isConnected(a,d,g) && !isConnected(b,c,g)) return true;
        return false;
    }

    private boolean isConnected(int x, int y, ArrayList<Integer>[] g) {
        return g[x].contains(y);
    }
}