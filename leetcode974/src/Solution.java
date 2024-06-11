class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] map = new int[k];
        int cnt = 0, sum = 0;
        map[0] = 1;
        for (int num : nums) {
            sum += num;
            int rem = (sum % k + k) % k;
            cnt += map[rem];
            map[rem]++;
        }
        return cnt;
    }
}