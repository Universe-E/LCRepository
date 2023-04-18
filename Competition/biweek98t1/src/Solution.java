class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        char[] cs = s.toCharArray();
        char max = '9',min = cs[0];
        //找到第一个不等于9的位置，并将其位置所在数字换为9
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] != '9') {
                max = cs[i];
                break;
            }
        }
        int maxs = 0,mins = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == max) maxs = maxs*10 + 9;
            else maxs = maxs*10 + (cs[i]-'0');
        }
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == min) mins = mins*10;
            else mins = mins*10 + (cs[i] - '0');
        }
        return maxs-mins;

    }
}