import java.util.HashSet;

class Solution {
    public int closestToTarget(int[] arr, int target) {
        int n = arr.length;
        int res = 0x3f3f3f3f;
        HashSet<Integer> set = new HashSet<>();
        set.add(-1);
        for (int value : arr) {
            HashSet<Integer> curSet = new HashSet<>();
            for (Integer num : set) {
                curSet.add(num & value);
                res = Math.min(res, Math.abs((num & value) - target));
            }
            curSet.add(-1);
            set = curSet;
        }
        return res;
    }
}