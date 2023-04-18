import java.util.Arrays;

class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int n = nums.length, len = groups.length;
        int pNums = 0, idx = 0;
        while (pNums < n) {
            int cur = pNums;
            if (nums[cur] == groups[idx][0]) {
                //index out of bound
                if (cur+groups[idx].length > n) return false;
                int[] temp = Arrays.copyOfRange(nums,cur,cur+groups[idx].length);
                //verify all the subarray
                if (verify(temp,groups[idx])) {
                    if (idx == len - 1) return true;
                    pNums += groups[idx].length;
                    idx++;
                }
                else pNums++;
            }
            else pNums++;
        }
        return false;
    }

    private boolean verify(int[] temp, int[] group) {
        int n = temp.length;
        for (int i = 0; i < n; i++) {
            if (temp[i] != group[i]) return false;
        }
        return true;
    }
}