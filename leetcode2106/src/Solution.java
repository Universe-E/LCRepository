class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length,res = 0;
        //先枚举从start往左走到fruits[l][0]，再往右走的情况，此时走过的距离为2*(start-fruits[l][0])+(fruits[r][0]-start)
        for (int l = 0,r = 0,cur = 0; l < n; l++) {
            while (r < n && 2*Math.max(startPos-fruits[l][0],0)+Math.max(fruits[r][0]-startPos,0) <= k) {
                cur += fruits[r][1];
                r++;
            }
            res = Math.max(res,cur);
            cur -= fruits[l][1];
        }
        //再枚举从start往右走到fruits[r][0]，再往左走的情况，此时走过的距离为2*(fruits[r][0]-start)+(start-fruits[l][0])
        for (int l = 0, r = 0,cur = 0; l < n; l++) {
            while (r < n && 2*Math.max(fruits[r][0]-startPos,0)+Math.max(startPos-fruits[l][0],0) <= k) {
                cur += fruits[r][1];
                r++;
            }
            res = Math.max(res, cur);
            cur -= fruits[l][1];
        }
        return res;
    }
}

class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length,res = 0;
        //二分查找到左边界lb
        int lb = bs_ceiling(fruits,startPos-k);
        for (int rb = lb,cur = 0; rb < n && fruits[rb][0] <= startPos+k;rb++) {
            cur += fruits[rb][1];
            //两种情况：
            //1、先向右再向左，此时移动距离为f[r][0]-s+f[r][0]-f[l][0]=2f[r][0]-s-f[l][0]
            //2、先向左再向右，此时移动距离为s-f[l][0]+f[r][0]-f[l][0]=s+f[r][0]-2f[l][0]
            while (lb < n && 2*fruits[rb][0]-startPos-fruits[lb][0] > k && startPos+fruits[rb][0]-2*fruits[lb][0] > k) {
                cur -= fruits[lb++][1];
            }
            res = Math.max(res,cur);
        }
        return res;
    }

    //开区间查找，避免找不到的情况
    private int bs_ceiling(int[][] fruits,int t) {
        int l = -1,r = fruits.length;
        while (l+1 < r) {//开区间不为空
            int m = (l+r)/2;
            if (fruits[m][0] < t) l = m;
            else r = m;
        }
        return r;
    }
}