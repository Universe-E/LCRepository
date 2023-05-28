import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    static boolean inited = false;
    static ArrayList<Integer>[] ps = new ArrayList[100001];
    static void init() {
        if (inited) return;
        inited = true;
        Arrays.setAll(ps,e->new ArrayList<>());
        for (int i = 2; i <= 100000; i++) {
            if (ps[i].isEmpty()) for (int j = i;j <= 100000; j+=i) ps[j].add(i);
        }
    }
    int[] fa,sz;
    public int largestComponentSize(int[] nums) {
        init();
        int n = nums.length,mx = 0;
        for (int num : nums) mx = Math.max(mx,num);
        fa = new int[n+mx+1];//质因数移位
        sz = new int[n+mx+1];
        for (int i = 0; i <= n+mx; i++) {
            fa[i] = i;
        }
        //将i与nums[i]所在质因数连边
        for (int i = 0; i < n; i++) {
            for (Integer p : ps[nums[i]]) {
                union(i,p+n);
            }
        }
        for (int i = 0; i < n; i++) {
            sz[find(i)]++;//如果i是nums中元素，则sz自增
        }
        return Arrays.stream(sz).max().getAsInt();

    }

    private int find(int i) {
        return fa[i] == i ? i : (fa[i] = find(fa[i]));
    }

    private void union(int x,int y) {
        int fx = find(x),fy = find(y);
        if (fx != fy) fa[fx] = fy;
    }
}