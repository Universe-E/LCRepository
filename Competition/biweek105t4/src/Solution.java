import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    static boolean inited = false;
    static ArrayList<Integer>[] fac = new ArrayList[100005];
    //全局预处理质数，在[2,100000]范围内找到每个数的质因数
    static void init() {
        if (inited) return;
        inited = true;
        Arrays.setAll(fac,e->new ArrayList<>());
        for (int i = 2; i <= 100000; i++) {
            //将i添加到所有i的倍数所在list，例如：
            //i=2时，将2添加到2,4,6,8,10,12,14,16,18...
            //i=3时，将3添加到3,6,9,12,15...
            //i=4时，4非空，因此跳过
            //i=5时，将5添加到5,10,15...
            if (fac[i].isEmpty()) {
                for (int j = i; j <= 100000; j+=i) {
                    fac[j].add(i);
                }
            }
        }
    }
    int[] fa;
    public boolean canTraverseAllPairs(int[] nums) {
        init();
        int n = nums.length, mx = 0;
        //找到mx中最大值
        for (int num : nums) {
            mx = Math.max(mx, num);
        }
        //在并查集数组中，前n个元素是nums，后mx个元素是p+n，p为质数，最大为mx，为方便处理索引移位n
        fa = new int[n+mx+1];
        for (int i = 0; i <= n+mx; i++) {
            fa[i] = i;
        }
        //对于每个nums[i]，向它的质因数连边，这样每个nums[i]的质因数合并为1个集合
        for (int i = 0; i < n; i++) {
            for (Integer p : fac[nums[i]]) {
                union(i,p+n);
            }
        }
        //判断是否能找到共有质因数
        int f0 = find(0);
        for (int i = 0; i < n; i++) {
            if (find(i) != f0) return false;
        }
        return true;
    }

    private int find(int i) {
        if (i == fa[i]) return i;
        return fa[i] = find(fa[i]);
    }

    private void union(int x,int y) {
        int fx = find(x), fy = find(y);
        if (fx != fy) fa[fx] = fy;
    }



}