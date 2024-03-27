class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] cnt = new int[101];
        for (int num : nums) {
            cnt[num]++;
        }
        int max = 0;
        for (int i : cnt) {
            max = Math.max(max,i);
        }
        int res = 0;
        for (int i : cnt) {
            if (i == max) res += i;
        }
        return res;
    }
}