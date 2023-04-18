class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0, r = n-1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) return new int[] {l+1,r+1};
            if (sum > target) r--;
            else l++;
        }
        throw new IllegalArgumentException("No solution.");
    }
}