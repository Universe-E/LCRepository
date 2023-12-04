class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, sum = 0, except = 0;
        for (int i = 0; i < n; i++) {
            if (i < n-k) except += cardPoints[i];
            sum += cardPoints[i];
        }
        int res = sum-except;
        for (int i = n-k; i < n; i++) {
            except -= cardPoints[i-n+k];
            except += cardPoints[i];
            res = Math.max(res,sum-except);
        }
        return res;
    }
}