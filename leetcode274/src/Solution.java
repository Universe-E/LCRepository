import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int l = 0, r = citations.length - 1;
        int mid;
        while (l <= r) {
            mid = (l + r + 1) / 2;
            if (citations[mid] >= citations.length - mid) {
                r = mid - 1;
            }
            else {
                l = mid;
                if (l == r) break;
            }
        }
        return citations.length - 1 - r;
    }
}

class Solution2 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = Math.min(1,citations[citations.length - 1]);
        for (int i = citations.length - 2; i >= 0; i--) {
            if (citations[i] > h) h++;
        }
        return h;
    }
}
