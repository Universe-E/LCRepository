class Solution {
    public int findLUSlength(String[] strs) {
        int n = strs.length, res = -1;
        for (int i = 0; i < n; i++) {
            String s1 = strs[i];
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                String s2 = strs[j];
                if (match(s1,s2)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res = Math.max(res,s1.length());
            }
        }
        return res;
    }
    private boolean match(String s1,String s2) {
        int i = 0;
        for (int j = 0; j < s2.length(); j++) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
            }
            if (i == s1.length()) return true;
        }
        return false;
    }
}