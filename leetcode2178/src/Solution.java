import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> list = new ArrayList<>();
        if (finalSum % 2 != 0) return list;
        long a = 2;
        while (finalSum >= a) {
            list.add(a);
            finalSum -= a;
            a += 2;
        }
        long an = list.remove(list.size() - 1) + finalSum;
        list.add(an);
        return list;
    }
}