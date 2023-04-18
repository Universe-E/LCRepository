import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] countMod = new int[value];
        for (int num : nums) {
            int index = (num%value+value)%value;
            countMod[index]++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < value; i++) {
            for (int j = 0; j < countMod[i]; j++) {
                list.add(i+value*j);
            }
        }
        Collections.sort(list);
        int res = 0;
        for (Integer num : list) {
            if (num == res) res++;
            else if (num > res) break;
        }
        return res;
    }
}