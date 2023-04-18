import java.util.ArrayList;

class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int[] arr = new int[155];
        int cnt = 0;
        for (int i = 0; i < numOnes; i++) {
            arr[cnt++] = 1;
        }
        for (int i = 0; i < numZeros; i++) {
            arr[cnt++] = 0;
        }
        for (int i = 0; i < numNegOnes; i++) {
            arr[cnt++] = -1;
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            res += arr[i];
        }
        return res;
    }
}