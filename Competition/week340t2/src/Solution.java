import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list;
            if (!map.containsKey(nums[i])) {
                list = new ArrayList<>();
            }
            else {
                list = map.get(nums[i]);
            }
            list.add(i);
            map.put(nums[i], list);
        }
        long[] res = new long[n];
        for (Integer num : map.keySet()) {
            List<Integer> list = map.get(num);
            Collections.sort(list);
            int ln = list.size();
            //当前的索引前缀和
            if (ln == 1) {
                res[list.get(0)] = 0;
                continue;
            }
            long[] pre = new long[ln+1];
            for (int i = 1; i <= ln; i++) {
                pre[i] = pre[i-1] + list.get(i-1);
            }
            for (int i = 0; i < ln; i++) {
                int idx = list.get(i);
                res[idx] = pre[ln]-pre[i+1]-(long)(ln-i-1)*idx + ((long)i*idx-(pre[i]-pre[0]));
            }
        }
        return res;
    }
}