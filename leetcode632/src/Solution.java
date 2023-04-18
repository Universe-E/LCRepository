import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        int n = 0;
        for (List<Integer> num : nums) n += num.size();
        //record the group index of each num
        int[][] all = new int[n][2];
        int i = 0,j = 0;
        for (List<Integer> num : nums) {
            for (Integer nu : num) {
                all[i][0] = nu;
                all[i][1] = j;
                i++;
            }
            j++;
        }
        Arrays.sort(all, Comparator.comparingInt(o->o[0]));
        //record the occurrence times of each group of the sliding window
        HashMap<Integer,Integer> map = new HashMap<>();
        //sort according to the num
        //initialize res
        int l = 0, res = all[n-1][0] - all[0][0];
        int[] ans = new int[] {all[0][0],all[n-1][0]};
        for (int[] arr : all) {
            map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
            //sliding window, get the first unqualified left bound
            while (map.keySet().size() == k) {
                int[] ls = all[l];
                if (map.put(ls[1], map.get(ls[1])-1) == 1) map.remove(ls[1]);
                l++;
            }
            if (l != 0) {
                int diff = arr[0] - all[l-1][0];
                if (diff < res) {
                    res = diff;
                    ans = new int[]{all[l-1][0], arr[0]};
                }
            }
        }
        return ans;
    }
}