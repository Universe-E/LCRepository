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
