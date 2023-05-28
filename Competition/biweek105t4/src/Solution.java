import java.util.ArrayList;
import java.util.Arrays;

class Init {
    static boolean inited = false;
    static ArrayList<Integer>[] fac = new ArrayList[100005];
    static void init() {
        if (inited) return;
        inited = true;
        Arrays.setAll(fac,e->new ArrayList<>());
        for (int i = 2; i <= 100000; i++) {
            if (fac[i].isEmpty()) {
                for (int j = i; j <= 100000; j+=i) {
                    fac[j].add(i);
                }
            }
        }
    }
}
class Solution {
    int[] fa;
    public boolean canTraverseAllPairs(int[] nums) {

    }

    private int find(int i) {
        if (i == fa[i]) return i;
        return fa[i] = find(fa[i]);
    }

    private void union(int x,int y) {
        int fx = find(x), fy = find(y);
        if (fx != fy) fa[fx] = fy;
    }

    private int gcd(int a,int b) {
        return b == 0 ? a : gcd(b,a%b);
    }
}