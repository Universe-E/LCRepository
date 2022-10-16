class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        //周期为2 * numRows - 2；这里首先声明二维数组的列数，如果能和Z字形周期除尽则列数为周期数*2，否则列数为(周期数+1)*2
        int t = 2 * numRows - 2;
        int numColumns = s.length() % (t) == 0
                ? 2 * (s.length() / (t)) + 1
                : 2 * (s.length() / (t)) + 3;
        //声明二维char型数组
        char[][] str = new char[numRows][numColumns];
        //接下来将字符串s按Z字形填入二维数组str
        //   a     i
        //     b   h   j
        //     c   g   k
        //     d   f   l
        //     e       m
        for (int i = 0, x = 0, y = 0; i < s.length(); i++) {
            str[x][y] = s.charAt(i);
            //当遍历到新周期时，向右下移动
            if (i % t == 0){
                x++;
                y++;
            }
            //从Z字形顶部遍历到底部
            if (i % t > 0 && i % t < numRows - 1){
                x++;
            }
            //当到达Z字形底部时，触底反弹，向右上移动
            if (i % t == numRows - 1){
                y++;
                x--;
            }
            //从Z字形底部遍历到顶部
            if (i % t > numRows - 1 && i % t < t){
                x--;
            }
        }

        StringBuilder res = new StringBuilder();
        for (char[] chars : str) {
            for (char c : chars) {
                if (c != 0) res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "abcdefghijklmn";
        int numRows = 5;
        System.out.println(new Solution().convert(s,numRows));
    }
}
