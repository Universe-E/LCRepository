class Solution {
    public String convertToBase7(int num) {
        Integer.toString(num,7);
        if (num==0) return "0";
        int p = Math.abs(num);
        int res = 0;
        while (p != 0) {
            int cur = 7;
            int re = 0;
            while (p >= cur) {
                cur *= 7;
                re++;
            }
            cur /= 7;
            int diff = p/cur;
            p %= cur;
            res += diff * Math.pow(10,re);
        }
        if (num > 0) return String.valueOf(res);
        else return "-" + res;
    }

    public static void main(String[] args) {
        int num = 120;
        System.out.println(new Solution().convertToBase7(num));
    }
}