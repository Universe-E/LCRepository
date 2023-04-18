class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int l = 0, r = n-1;
        while (l < r) {
            int mid = l + (r-l) / 2;
            int mr = arr[mid],lr = mid == 0 ? -1 : arr[mid-1],rr = mid == n-1 ? -1 : arr[mid+1];
            if (mr > lr && mr > rr) return mid;
            if (mr < lr && mr > rr) r = mid-1;
            if (mr > lr && mr < rr) l = mid+1;
        }
        return l;
    }
}