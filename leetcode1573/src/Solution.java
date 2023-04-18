class Solution {
    public int numWays(String s) {
        int n = s.length(), M = (int)(1e9+7);
        //store the number of 1,must be divisible by 3
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') cnt++;
        }
        if (cnt == 0) return (int) (((long)(n-1)*(n-2))/2 % M);
        if (cnt % 3 != 0) return 0;
        int diff = cnt / 3;
        //find the possible partition index
        int end1 = 0,start2 = 0,end2 = 0,start3 = 0,cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                cnt2++;
                if (cnt2 == diff) end1 = i;
                if (cnt2 == diff+1) start2 = i;
                if (cnt2 == 2*diff) end2 = i;
                if (cnt2 == 2*diff+1) start3 = i;
            }
        }
        return (int) ((long)(start2-end1)*(start3-end2) % M);
    }
}