class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        //由于元素种类有限，可以用常量数组cnt记录字母出现个数
        int[] cnt = new int[26];
        int l = 0, res = 0;
        for (int r = 0; r < n; r++) {
            cnt[s.charAt(r)-'A']++;
            //如果不满足条件，左边界必须收缩，即向右收缩，直到到达第一个满足条件的左边界为止
            while (l <= r && !checkMost(cnt,k,l,r)) {
                cnt[s.charAt(l)-'A']--;
                l++;
            }
            //在此期间不断记录最大的滑动窗口宽度
            res = Math.max(res,r-l+1);
        }
        return res;
    }

    //判断当前窗口频率最高的重复字符，记为most
    //如果most+k >= r-l+1，则说明当前窗口满足修改k次即可全部重复的条件
    private boolean checkMost(int[] cnt, int k,int l, int r) {
        int most = 0;
        for (int i : cnt) {
            most = Math.max(most,i);
        }
        return most+k >= r-l+1;

    }
}