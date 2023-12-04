class Solution {
    public int countPoints(String rings) {
        int[][] cnt = new int[10][3];
        for (int i = 0; i < rings.length(); i+=2) {
            char c1 = rings.charAt(i);
            int id = rings.charAt(i+1)-'0';
            if (c1 == 'R') cnt[id][0]++;
            if (c1 == 'G') cnt[id][1]++;
            if (c1 == 'B') cnt[id][2]++;
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            if (cnt[i][0] != 0 && cnt[i][1] != 0 && cnt[i][2] != 0) res++;
        }
        return res;
    }
}