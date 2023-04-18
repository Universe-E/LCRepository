class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] cnt = new int[256];
        int l = 0, n = s.length(),res = 0;
        for (int i = 0; i < n; i++) {
            //find the qualified left bound
            while (cnt[s.charAt(i)] > 0) cnt[s.charAt(l++)]--;
            cnt[s.charAt(i)]++;
            res = Math.max(res,i-l+1);
        }
        return res;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] cnt = new int[256];
        int l = 0, r = -1, n = s.length(),res = 0;
        while (l < n) {
            //如果右边界还能拓展
            if (r != n-1 && cnt[s.charAt(r+1)] == 0) cnt[s.charAt(++r)]++;
            //否则需要缩短左边界
            else cnt[s.charAt(l++)]--;
            res = Math.max(res,r-l+1);
        }
        return res;
    }
}