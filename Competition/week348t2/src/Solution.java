class Solution {
    int[] arr;
    public int semiOrderedPermutation(int[] nums) {
        arr = nums;
        int n = arr.length,l = 0,r = n-1;
        while (arr[l] != 1) l++;
        while (arr[r] != n) r--;
        if (l < r) return l + n-r-1;
        else return l+n-r-2;
    }
}