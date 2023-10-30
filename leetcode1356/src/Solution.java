import java.util.Arrays;

class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        Integer[] arr2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = arr[i];
        }
        Arrays.sort(arr2,(o1,o2) -> {
            int cnt1 = Integer.bitCount(o1),cnt2 = Integer.bitCount(o2);
            if (cnt1 == cnt2) return o1-o2;
            return cnt1-cnt2;
        });
        for (int i = 0; i < n; i++) {
            arr[i] = arr2[i];
        }
        return arr;
    }
}