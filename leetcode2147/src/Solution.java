class Solution {
    public static final int M = (int) 1e9+7;
    public int numberOfWays(String corridor) {
        int sum = 0,n = corridor.length();
        int cur = 0,res = 1;
        for (int i = 0; i < n; i++) {
            char c = corridor.charAt(i);
            if (c == 'S') {
                if (sum > 0 && sum%2 == 0) {
                    res = (int) (((long)res * (cur+1))%M);
                    cur = 0;
                }
                sum++;
            }
            else {
                if (sum > 0 && sum%2==0) cur++;
            }
        }
        if (sum == 0 || sum%2 != 0) return 0;
        return res;
    }
}