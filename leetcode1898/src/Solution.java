import java.util.Arrays;

class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int len = removable.length;
        //边界情况要单独判断
        if (len == 0) return 0;
        //为避免对removable[0]单独讨论，可以设l = -1
        int l = -1, r = len - 1;
        while (l < r) {
            //由于左边界可能不更新，每次二分取右值，否则可能会死锁
            int m = (l + r + 1) / 2;
            int[] removes = Arrays.copyOfRange(removable,0,m + 1);
            if (check(s,p,removes)) l = m;
            else r = m - 1;
        }
        return l + 1;
    }

    private boolean check(String s, String p, int[] removes) {
        char[] cs = s.toCharArray();
        for (int remove : removes) cs[remove] = ' ';
        int j = 0;
        for (char c : cs) {
            if (c != ' ' && c == p.charAt(j)) j++;
            if (j == p.length()) break;
        }
        return j == p.length();
    }
}