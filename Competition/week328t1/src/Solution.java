class Solution {
    public int differenceOfSum(int[] nums) {
        int sum = 0;
        int suf = 0;
        for (int num : nums) {
            sum += num;
            String s = String.valueOf(num);
            for (int i = 0; i < s.length(); i++) {
                suf += s.charAt(i) - '0';
            }
        }
        return Math.abs(sum-suf);
    }
}