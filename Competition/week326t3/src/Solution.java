class Solution {
    public int minimumPartition(String s, int k) {
        char[] cs = s.toCharArray();
        long res = 1,cur = 0;
        for (char c : cs) {
            if (c - '0' > k) return -1;
            if (cur * 10 + c - '0' <= k) {
                cur = cur * 10 + c - '0';
            }
            else {
                cur = c - '0';
                res++;
            }
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumPartition("264561",60));
    }
}