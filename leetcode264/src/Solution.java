import java.util.ArrayList;
import java.util.List;

class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int p2 = 0, p3 = 0, p5 = 0,ptr = 0;
        while (ptr < n) {
            int cur = Math.min(2 * list.get(p2),Math.min(3 * list.get(p3),5 * list.get(p5)));
            if (cur % 2 == 0) p2++;
            if (cur % 3 == 0) p3++;
            if (cur % 5 == 0) p5++;
            list.add(cur);
            ptr++;
        }
        return list.get(ptr - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(11));
    }
}