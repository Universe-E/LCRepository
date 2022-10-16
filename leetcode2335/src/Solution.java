import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int fillCups(int[] amount) {
        int count = 0;
        //先排序
        Arrays.sort(amount);
        while (!(amount[0] == 0 && amount[1] == 0 && amount[2] == 0)) {
            //每次接水前判断是否已经排序，如果没有排序就重新排序
            if (!(amount[0] <= amount[1] && amount[1]<= amount[2])) Arrays.sort(amount);

            amount[2]--;
            if (amount[0] <= amount[1] && amount[0] != 0) {
                amount[0]--;
            } else if (amount[1] != 0){
                amount[1]--;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] amount = {5,4,4};
        int res = new Solution().fillCups(amount);
        System.out.println(res);
    }


}
