class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for (int k : arr1) {
            cnt[k]++;
        }
        int[] res = new int[arr1.length];
        int j = 0;
        for (int target : arr2) {
            while (cnt[target] > 0) {
                res[j] = target;
                j++;
                cnt[target]--;
            }
        }
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 0) continue;
            while (cnt[i] > 0) {
                res[j] = i;
                j++;
                cnt[i]--;
            }
        }
        return res;
    }
}