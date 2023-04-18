import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int sum = 0,cnt2 = 0, valid = 0;
        for (int num : colsum) {
            sum += num;
            if (num != 0) valid++;
            if (num == 2) cnt2++;
        }
        if (sum != upper + lower || valid < Math.max(upper,lower)) return new ArrayList<>();
        List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        //cnt2 must be less than upper
        int cnt1 = upper - cnt2;
        for (int value : colsum) {
            if (value == 2) {
                l1.add(1);
                l2.add(1);
            }
            else if (value == 1) {
                //fulfill l1
                if (cnt1 != 0) {
                    l1.add(1);
                    l2.add(0);
                    cnt1--;
                }
                else {
                    l1.add(0);
                    l2.add(1);
                }
            }
            else {
                l1.add(0);
                l2.add(0);
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        return list;
    }
}