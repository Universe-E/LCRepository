class Solution {
    public int countTime(String time) {
        char[] cs = time.toCharArray();
        int res = 1;
        if (cs[4] == '?') res *= 10;
        if (cs[3] == '?') res *= 6;
        if (cs[0] == '0' || cs[0] == '1') {
            if (cs[1] == '?') res *= 10;
        }
        else if (cs[0] == '2') {
            if (cs[1] == '?') res *= 4;
        }
        else if (cs[0] == '?') {
            if (cs[1] == '?') res *= 24;
            else if (cs[1] - '0' > 3) res *= 2;//如果cs[1]是456789，cs[0]只能0和1
            else res *= 3;//012都行
        }
        return res;
    }
}