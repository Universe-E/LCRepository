import java.util.Arrays;

class Solution {
    public String getSmallestString(int n, int k) {
        char[] cs = new char[n];
        //先全部填a
        Arrays.fill(cs,'a');
        k -= n;
        int i = n-1;
        //如果k满足>=25，则从后往前填z
        while (k >= 25) {
            cs[i--] = 'z';
            k -= 25;
        }
        //如果k还有剩余，则修改当前位即可
        if (k != 0) cs[i] = (char) ('a'+k);
        return new String(cs);
    }
}