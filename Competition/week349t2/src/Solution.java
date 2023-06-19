class Solution {
    public String smallestString(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length,r = 0;
        //找到第一个不全是a的子串
        while (r < n && cs[r] == 'a') r++;
        while (r < n && cs[r] != 'a') r++;
        int l = 0;
        while (l < n-1 && cs[l] == 'a') l++;
        for (int i = l; i < Math.min(r,n); i++) {
            if (cs[i] == 'a') cs[i] = 'z';
            else cs[i]--;
        }
        return new String(cs);

    }
}