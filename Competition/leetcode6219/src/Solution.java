class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for (int i = num; i >= 0; i--) {
            char[] cs = String.valueOf(i).toCharArray();
            int len = cs.length;
            int t = 0;
            for (int j = 0; j < len; j++) {
                t += (cs[j] - '0') * (int)(Math.pow(10,j));
            }
            if (t + i == num) return true;
        }
        return false;
    }
}