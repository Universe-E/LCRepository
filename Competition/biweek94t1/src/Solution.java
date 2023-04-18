class Solution {
    public int captureForts(int[] forts) {
        int n = forts.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (forts[i] == 1) {
                int left = 0,right = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (forts[j] == 0) left++;
                    if (forts[j] == 1 || (j == 0 && forts[j] != -1)) {
                        left = 0;
                        break;
                    }
                    if (forts[j] == -1) break;
                }
                for (int j = i + 1; j < n; j++) {
                    if (forts[j] == 0) right++;
                    if (forts[j] == 1 || (j == n-1 && forts[j] != -1)) {
                        right = 0;
                        break;
                    }
                    if (forts[j] == -1) break;
                }
                res = Math.max(res, Math.max(left,right));
            }
        }
        return res;
    }
}