import java.util.ArrayList;
import java.util.List;

class Solution {
    public int averageValue(int[] nums) {
        int res = 0,cnt = 0;
        for (int num : nums) {
            if (num % 2 == 0 && num % 3 == 0) {
                cnt++;
                res += num;
            }
        }
        if (cnt == 0) return 0;
        return res / cnt;
    }
}