class Solution {
    public int countBeautifulPairs(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            String si = String.valueOf(nums[i]);
            for (int j = i+1; j < n; j++) {
                String sj = String.valueOf(nums[j]);
                if (gcd(si.charAt(0)-'0',sj.charAt(sj.length()-1)-'0') == 1) res++;
            }
        }
        return res;
    }

    private int gcd(int a,int b) {
        return a%b == 0 ? b : gcd(b,a%b);
    }
}