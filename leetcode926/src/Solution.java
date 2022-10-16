class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        //zeros记录当前位置（不包括当前位置）后面有多少个0，ones记录前面有多少个1
        int[] zeros = new int[n];
        int[] ones = new int[n];
        int res1 = 0,res2 = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) == '1') res1++;
            ones[i] = res1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i + 1) == '0') res2++;
            zeros[i] = res2;
        }
        int res = n;
        //ones[i] + zeros[i]表示当前位置的最少修改次数
        for (int i = 0; i < n; i++) {
            res = Math.min(res,ones[i] + zeros[i]);
        }
        return res;
    }
}