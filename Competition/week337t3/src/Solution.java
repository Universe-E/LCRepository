import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        int n = nums.length;
        ArrayList<Integer>[] a = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int num : nums) {
            for (int i = 0; i < n; i++) {
                if (!a[i].contains(num-k) && !a[i].contains(num+k)) {
                    a[i].add(num);
                    break;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int an = a[i].size();
            if (an != 0) {
                res += ((1<<an) -1);
            }
        }
        return res;
    }
}