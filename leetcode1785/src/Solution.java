class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long dif = Math.abs(goal - sum);
        return (int) (dif/limit + (dif%limit==0 ? 0 : 1));
    }
}