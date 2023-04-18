class Solution {
    public int beautifulBouquet(int[] flowers, int cnt) {
        int n = flowers.length, res = 0, M = (int)(1e9+7);
        int[] fs = new int[100001];
        int l = 0;
        for (int i = 0; i < n; i++) {
            fs[flowers[i]]++;
            while (fs[flowers[i]] > cnt) fs[flowers[l++]]--;
            res = (res+i-l+1)%M;
        }
        return res;
    }
}