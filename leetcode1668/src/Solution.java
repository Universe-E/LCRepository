class Solution {
    public int maxRepeating(String sequence, String word) {
        int n = sequence.length(),m = word.length();
        int res = 0;
        for (int i = 0; i <= n - m; i++) {
            int j = i;
            int cnt = 0;
            while (j <= n-m) {
                if (!sequence.substring(j,j+m).equals(word)) {
                    cnt = 0;
                    j++;
                }
                else {
                    cnt++;
                    res = Math.max(res,cnt);
                    j += m;
                }
            }
        }
        return res;
    }
}