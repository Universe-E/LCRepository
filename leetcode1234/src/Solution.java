class Solution {
    public int balancedString(String s) {
        int[] cnt = new int[4];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            f(c,cnt,true);
        }
        boolean ok = true;
        for (int i = 0; i < 4; i++) {
            if (cnt[i] > n/4) {
                cnt[i] -= n/4;
                ok = false;
            }
            else cnt[i] = 0;
        }
        if (ok) return 0;
        //找出多出的字母个数，问题转化为寻找包含这么多字母的最短子串
        //l每次前进到第一个不满足条件的位置
        int l = 0,res = n;
        int[] cur = new int[4];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            f(c,cur,true);
            while (l < n && check(cur,cnt)) {
                char lc = s.charAt(l);
                f(lc,cur,false);
                l++;
            }
            if (l != 0) res = Math.min(res,i-l+2);
        }
        return res;
    }

    private boolean check(int[] cur,int[] cnt) {
        for (int i = 0; i < 4; i++) {
            if (cnt[i] != 0) {
                if (cur[i] < cnt[i]) return false;
            }
        }
        return true;
    }

    private void f(char c,int[] arr,boolean add) {
        if (add) {
            if (c == 'Q') arr[0]++;
            if (c == 'W') arr[1]++;
            if (c == 'E') arr[2]++;
            if (c == 'R') arr[3]++;
        }
        else {
            if (c == 'Q') arr[0]--;
            if (c == 'W') arr[1]--;
            if (c == 'E') arr[2]--;
            if (c == 'R') arr[3]--;
        }

    }
}