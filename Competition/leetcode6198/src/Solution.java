import java.util.Arrays;

class Solution {
    long res;
    int diff;
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            cnt[i] = nums1[i] - nums2[i];
        }
        //问题转化为cnt[i] - cnt[j] <= diff的组数
        this.diff = diff;

    }

    private void mergeSort(int[] cnt,int i,int j) {
        if (i >= j - 1) return;
        int mid = (i + j) / 2;
        mergeSort(cnt,i,mid);
        mergeSort(cnt,mid,j);
        //此时[i,j)区间已经有序
        for (int m = i, n = mid; n < j; ) {
            if (m < mid && cnt[m] <= cnt[n] + diff) m++;
            else {
                res += m - i;
                n++;
            }
        }

    }
}