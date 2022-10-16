class Solution {
    public int minimumRecolors(String blocks, int k) {
        int BTimes = 100;
        for (int i = 0; i < blocks.length() - k + 1; i++) {
            int curBTimes = 0;
            for (int j = i; j < i + k; j++) {
                if (blocks.charAt(j) == 'W') curBTimes++;
            }
            BTimes = Math.min(BTimes,curBTimes);
        }
        return BTimes;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumRecolors("WBBWWBBWBW",4));
    }
}