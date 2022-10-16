class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String s = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();
        //注意i无需自增，每次只让下一组数字的头部
        for (int i = 0; i < s.length();) {
            int j = i,count = 0;//取相同数字为一组遍历
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                count++;
                j++;
            }
            res.append(count);
            res.append(s.charAt(i));
            i = j;//遍历完该组数字之后，让i来到当前j的位置
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(30));
    }
}
