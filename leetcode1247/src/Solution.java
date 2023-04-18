class Solution {
    public int minimumSwap(String s1, String s2) {
        int n = s1.length(), x = 0, y = 0;
        //查找需要交换的个数
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i)=='x' && s2.charAt(i)=='y') x++;
            else if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') y++;
        }
        //需要交换的总数必须为偶数
        if ((x+y) % 2 != 0) return -1;
        //分类讨论
        if (x%2==0 && y%2==0) return x/2 + y/2;
        return x/2 + y/2 + 2;
    }
}