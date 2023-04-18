import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+5];
        for (int num : nums) {
            arr[num]++;
        }
        List<List<Integer>> list = new ArrayList<>();
        while (true) {
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    cur.add(i);
                    arr[i]--;
                }
            }
            list.add(cur);
            boolean ok = true;
            for (int num : arr) {
                if (num != 0) {
                    ok = false;
                    break;
                }
            }
            if (ok) break;
        }
        return list;
    }
}