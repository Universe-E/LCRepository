class Solution {
    public int magicalString(int n) {
        StringBuilder s = new StringBuilder("122");
        if (n <= 3) return 1;
        int cnt = 3,i = 2;
        int swit = 1;
        int res = 1;
        while (true) {
            int plus = s.charAt(i) - '0';
            for (int j = 0; j < plus; j++,cnt++) {
                if (cnt == n) return res;
                s.append(swit);
                if (swit == 1) res++;
            }
            swit = 3 - swit;
            i++;
        }
    }
}