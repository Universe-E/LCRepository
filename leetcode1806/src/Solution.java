import java.util.Arrays;

class Solution {
    int[] perm;
    public int reinitializePermutation(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        perm = arr;
        System.out.println(Arrays.toString(perm));
        int res = 0;
        while (true) {
            int[] temp = Arrays.copyOf(arr,n);//注意不能是地址引用，必须是拷贝
            for (int i = 0; i < n; i++) {
                if (i%2 == 0) temp[i] = arr[i/2];
                else temp[i] = arr[n/2 + (i-1)/2];
            }
            res++;
            if (Arrays.equals(perm,temp))return res;
            arr = temp;
        }
    }
}