import java.util.ArrayList;
import java.util.List;

class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int[] div = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] % k == 0) div[i] = nums[i] / k;
            else div[i] = -1;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (div[i] == -1) continue;
            int cur = 0;
            List<Integer> list = new ArrayList<>();
            for (int j = i; j >= 0; j--) {
                if (div[j] == -1) break;
                //如果是第一个数，判断它是否就是k
                if (j == i) {
                    if (div[j] == 1) cur++;
                }
                //如果不是第一个数，则要与已经遍历的数字相除，判断是否互质
                else {
                    boolean isValid = false;
                    for (Integer num : list) {
                        int max = Math.max(num,div[j]),min = Math.min(num,div[j]);
                        //只要有一个数和div[j]互质，就可以留下来
                        if (min == 1 || max % min != 0) {
                            isValid = true;
                            break;
                        }
                    }
                    //只要有一个互质就能满足条件，但都不互质也不能直接break
                    if (isValid) cur++;
                }
                list.add(div[j]);
            }
            res += cur;
        }
        return res;
    }
}