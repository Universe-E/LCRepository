class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean[] v = new boolean[n];
        v[0] = true;
        int cnt = 1,i = 0;
        while (true) {
            int next = (i+cnt*k)%n;
            if (v[next]) break;
            v[next] = true;
            i = next;
            cnt++;
        }
        int[] res = new int[n-cnt];
        int id = 0;
        for (int j = 0; j < n; j++) {
            if (!v[j]) res[id++] = j+1;
        }
        return res;
    }
}