import java.awt.event.WindowFocusListener;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        //leftMax[i] 表示 arr[0] ~ arr[i] 的最大值
        //rightMin[i] 表示 arr[i]~arr[n - 1] 的最小值
        //对于 1~(n - 1) 的每一个i，只要 leftMax[i - 1] <= rightMin[i] 那么就可以在 i - 1 和 i 之间切断
        int[] maxArr = new int[arr.length];
        int[] minArr = new int[arr.length];
        int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            maxArr[i] = max;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < min) min = arr[i];
            minArr[i] = min;
        }
        int res = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (maxArr[i] <= minArr[i + 1]) res++;
        }
        return res;
    }
}
