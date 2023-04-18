import java.util.HashMap;

class Solution {
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length, meet = -1,res = 0,cnt = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < n; i++) {
            if (nums[i] < k) cnt--;
            else if (nums[i] > k)cnt++;
            else {
                meet = i;
                break;
            }
            //统计大于k的个数-小于k的个数，记为cnt
            map.put(cnt,map.getOrDefault(cnt,0)+1);
        }
        //单独处理第meet位
        res += map.getOrDefault(cnt,0) + map.getOrDefault(cnt-1,0);
        for (int i = meet+1; i < n; i++) {
            cnt += (nums[i] < k) ? -1 : 1;
            res += map.getOrDefault(cnt,0) + map.getOrDefault(cnt-1,0);
        }
        return res;
    }
}