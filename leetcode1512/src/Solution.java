class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] cnt = new int[101];
        for (int num : nums) {
            cnt[num]++;
        }
        int res = 0;
        for (int i = 1; i <= 100; i++) {
            res += cnt[i]*(cnt[i]-1)/2;
        }
        return res;
    }
}