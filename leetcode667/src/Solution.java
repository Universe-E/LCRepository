import java.util.Arrays;

class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i + 1;
        }
        //交换方法：例如[1,2,3,4,5,6,7]；
        //k = 6时：[1,7,2,6,3,5,4]；
        //k = 5时：[1,6,2,5,3,4,7]；
        //k = 4时：[1,5,2,4,3,6,7]
        //等等
        int[] temp = Arrays.copyOf(res, k + 1);
        int[] t1 = new int[k / 2 + 1], t2 = new int[temp.length - t1.length];
        if (t1.length >= 0) System.arraycopy(temp, 0, t1, 0, t1.length);
        for (int i = temp.length - 1,j = 0; i >= t1.length; i--, j++) t2[j] = temp[i];
        int i = 0, j = 0, m = 0;
        while (m < temp.length) {
            if (m % 2 == 0) {
                temp[m] = t1[i];
                i++;
            }
            else {
                temp[m] = t2[j];
                j++;
            }
            m++;
        }
        System.arraycopy(temp,0,res,0,temp.length);
        return res;
    }
}
