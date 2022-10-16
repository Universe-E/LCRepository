class Solution {
    public int longestIdealString(String s, int k) {
        int res = 0;
        int i = 0,count = 0;
        while (i < s.length()) {
            int j = i + 1,cur = 1;
            while (j < s.length()) {
                if (Math.abs(s.charAt(j) - s.charAt(i)) <= k) {
                    //如果满足条件，让i跟着j移动
                    i = j;
                    cur++;
                }
                else {
                    while (Math.a)
                }
                j++;
            }
            count++;
            i = count;
            res = Math.max(res, cur);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "eduktdb";
        int res = new Solution().longestIdealString(s,15);
        System.out.println(res);
    }
}
