class Solution {
    public boolean canChange(String start, String target) {
        String s1 = start.replaceAll("_",""),
                s2 = target.replaceAll("_","");
        if (!s1.equals(s2)) return false;
        int n = start.length();
        int[][] cnt1 = new int[n][2],cnt2 = new int[n][2];
        if (start.charAt(0) == 'L') cnt1[0][0]++;
        else if (start.charAt(0) == 'R') cnt1[0][1]++;
        if (target.charAt(0) == 'L') cnt2[0][0]++;
        else if (target.charAt(0) == 'R') cnt2[0][1]++;
        for (int i = 1; i < n; i++) {
            cnt1[i][0] = cnt1[i-1][0];
            cnt1[i][1] = cnt1[i-1][1];
            cnt2[i][0] = cnt2[i-1][0];
            cnt2[i][1] = cnt2[i-1][1];
            char c1 = start.charAt(i),c2 = target.charAt(i);
            if (c1 == 'L') cnt1[i][0]++;
            else if (c1 == 'R') cnt1[i][1]++;
            if (c2 == 'L') cnt2[i][0]++;
            else if (c2 == 'R') cnt2[i][1]++;
        }
        for (int i = 0; i < n; i++) {
            if (cnt1[i][0] > cnt2[i][0] || cnt1[i][1] < cnt2[i][1]) return false;
        }
        return true;
    }
}