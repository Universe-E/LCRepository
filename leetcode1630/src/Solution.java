import java.util.*;

class Solution {
    List<Boolean> list = new ArrayList<>();
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;
        for (int i = 0; i < m; i++) {
            int lb = l[i],rb = r[i],len = rb-lb+1;
            int[] arr = Arrays.copyOfRange(nums,lb,rb+1);
            Arrays.sort(arr);
            int d = arr[1]-arr[0];
            boolean v = true;
            for (int j = 1; j < len; j++) {
                if (arr[j]-arr[j-1] != d) {
                    v = false;
                    break;
                }
            }
            list.add(v);
        }
        return list;
    }
}