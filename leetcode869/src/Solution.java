class Solution {
    boolean valid = false;
    public boolean reorderedPowerOf2(int n) {
        char[] cs = String.valueOf(n).toCharArray();
        int len = cs.length;
        boolean[] visited = new boolean[len];
        backTrack(cs,visited,0,0);
        return valid;
    }

    private void backTrack(char[] cs, boolean[] visited, int k, int sum) {
        if (k == cs.length) {
            valid = is2Exponent(sum);
            return;
        }
        for (int i = 0; i < cs.length; i++) {
            if (k == 0 && cs[i] == '0') continue;
            if (visited[i]) continue;
            sum = sum * 10 + cs[i] - '0';
            visited[i] = true;
            backTrack(cs,visited,k+1,sum);
            if (valid) break;
            sum = (sum - cs[i] + '0') / 10;
            visited[i] = false;
        }
    }

    private boolean is2Exponent(int n) {
        if (n == 1) return true;
        if ((n & 1) != 0) return false;
        return is2Exponent(n/2);
    }
}