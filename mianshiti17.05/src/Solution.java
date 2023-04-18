import java.util.Arrays;

class Solution {
    public String[] findLongestSubarray(String[] array) {
        int n = array.length, net = 0, len = 0, left = -1;
        int[] cnt = new int[2*n+2];
        Arrays.fill(cnt, -2);
        cnt[n] = -1;
        for (int i = 0; i < n; i++) {
            net += Character.isLetter(array[i].charAt(0)) ? 1 : -1;
            int idx = n+net;
            if (cnt[idx] == -2) cnt[idx] = i;//首次出现时计入
                //如果包含，则说明中间区间有效
            else if (i-cnt[idx]>len) {
                len = i-cnt[idx];
                left = cnt[idx];
            }
        }
        return Arrays.copyOfRange(array,left+1,left+1+len);
    }
}