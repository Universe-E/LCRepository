class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length,m = mat[0].length,l = 0,r = n-1;
        while (l < r) {
            int mid = (l+r)/2;
            //求mid行的最大值索引，此时是行峰值
            int rowMax = getMax(mat[mid]);
            if (mat[mid][rowMax] > mat[mid+1][rowMax]) r = mid;
            else l = mid+1;
        }
        return new int[]{l,getMax(mat[l])};
    }

    private int getMax(int[] arr) {
        int max = -1,res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                res = i;
            }
        }
        return res;
    }
}