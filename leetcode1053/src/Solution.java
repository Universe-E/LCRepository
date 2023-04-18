class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        int p = -1;
        //find the lowest disordered element
        for (int i = n-2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                p = i;
                break;
            }
        }
        if (p == -1) return arr;
        //swap arr[i] with the largest element on the right of the i
        int sw = 0,p2 = 0;
        for (int i = p + 1; i < n; i++) {
            if (arr[i] >= arr[p]) continue;
            if (arr[i] > sw) {
                sw = arr[i];
                p2 = i;
            }
        }
        int temp = arr[p];
        arr[p] = sw;
        arr[p2] = temp;
        return arr;
    }
}