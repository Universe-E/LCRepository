class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length,p = -1;
        for (int i = n-1; i > 0; i--) {
            if (arr[i] < arr[i-1]) {
                p = i-1;
                break;
            }
        }
        if (p == -1) return arr;
        //找到p点右侧小于arr[p]的最大值
        int target = 0,p2 = -1;
        for (int i = p+1; i < n; i++) {
            if (arr[i] < arr[p] && arr[i] > target) {
                target = Math.max(target,arr[i]);
                p2 = i;
            }
        }
        int temp = target;
        arr[p2] = arr[p];
        arr[p] = temp;
        return arr;
    }
}