class Solution {
    public int maxScore(String s) {
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            String zero = s.substring(0, i + 1);
            String one = s.substring(i + 1);
            int numZero = 0, numOne = 0;
            for (int j = 0; j < zero.length(); j++) if (zero.charAt(j) == '0') numZero++;
            for (int j = 0; j < one.length(); j++) if (one.charAt(j) == '1') numOne++;
            max = Math.max(max, numZero + numOne);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "00";
        System.out.println(new Solution().maxScore(s));
    }
}
class Solution {
    public int maxScore(String s) {
        int n = s.length(),cnt0 = 0,cnt1 = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '1') cnt1++;
        }
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            char c = s.charAt(i);
            if (c == '0') cnt0++;
            else cnt1--;
            res = Math.max(res,cnt0+cnt1);
        }
        return res;
    }
}
