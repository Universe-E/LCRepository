import java.util.HashMap;

class Solution {
    public long beautifulSubarrays(int[] nums) {
        int n = nums.length;
        //统计子数组二进制每一位的出现个数，如果每一位均为偶数说明满足条件
        //由于最多有1e6，因此可以统计二进制21位以内即可
        int[] cnt = new int[21];
        //用map记录前缀和，统计每个key的出现次数
        HashMap<Integer,Integer> map = new HashMap<>();
        //这里key的定义为：第k位二进制位为1代表该位数量为奇数，否则代表该位数量为偶数
        map.put(0,1);//初始没有前缀和，21位均为偶数，key值为0
        long res = 0;
        for (int i = 0; i < n; i++) {
            //取二进制位每一位1
            for (int k = 0; k < 21; k++) {
                if (((nums[i]>>k)&1) == 1) {
                    nums[i] -= (1<<k);
                    cnt[k]++;
                }
            }
            //所有21位奇偶一致的，才能构成符合要求的区间
            //按照key的定义，计算key值
            int key = 0;
            for (int k = 0; k < 21; k++) {
                if (cnt[k]%2 != 0) key += (1<<k);
            }
            map.put(key,map.getOrDefault(key,0)+1);
        }
        //枚举map的每一个key
        for (Integer key : map.keySet()) {
            int v = map.get(key);
            res += (long)v*(v-1)/2;
        }
        return res;
    }
}

class Solution {
    public long beautifulSubarrays(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int s = 0;
        HashMap<Integer,Integer> cnt = new HashMap<>();
        cnt.put(0,1);
        for (int num : nums) {
            s ^= num;
            ans += cnt.getOrDefault(s, 0);
            cnt.merge(s, 1, Integer::sum);

        }
        return ans;
    }
}
