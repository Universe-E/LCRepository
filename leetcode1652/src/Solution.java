class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if (k == 0) return res;
        if (k > 0) {
            for (int i = 0; i < n; i++) {
                int j = (i + 1) % n,count = 0;
                while (count < k) {
                    res[i] += code[j];
                    j = (j + 1) % n;
                    count++;
                }
            }
        }
        else {
            for (int i = 0; i < n; i++) {
                int j = (i - 1 + n) % n, count = 0;
                while (count < -k) {
                    res[i] += code[j];
                    j = (j - 1 + n) % n;
                    count++;
                }
            }
        }
        return res;
    }
}