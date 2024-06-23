import java.util.ArrayList;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        //奇数所在坐标分割出来，每次框定k个奇数
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) list.add(i);
        }
        int sz = list.size();
        if (sz < k) return 0;
        int[] arr = new int[sz];
        for (int i = 0; i < sz; i++) {
            arr[i] = list.get(i);
        }
        int res = 0;
        //每次框定k个奇数
        for (int i = 0; i < sz - k + 1; i++) {
            //处理边界，i=0的左边界是-1，i=sz-k的右边界是n
            res += (arr[i] - (i == 0 ? -1 : arr[i - 1])) * ((i == (sz - k) ? n : arr[i + k]) - arr[i + k - 1]);
        }
        return res;
    }
}