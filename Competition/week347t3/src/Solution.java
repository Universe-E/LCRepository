class Solution {
    public long minimumCost(String s) {
        char[] cs = s.toCharArray();
        int n = s.length(),l = 0,r = n-1;
        long res = 0;
        while (l < r) {
            while (l < r && cs[l] == cs[l+1]) l++;
            while (r > l && cs[r-1] == cs[r]) r--;
            if (l + 1 < r) {
                //哪边少替换哪边
                if (l+1 > n-r) {
                    res += n-r;
                    r--;
                }
                else {
                    res += l+1;
                    l++;
                }

            }
            else {
                if (cs[l] != cs[r]) res += Math.min(l+1,n-r);
                l++;
                r--;
            }
        }
        return res;
    }
}