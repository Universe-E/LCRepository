import java.util.ArrayDeque;

class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        ArrayDeque<Integer> d = new ArrayDeque<>(),r = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = senate.charAt(i);
            if (c == 'D') d.addLast(i);
            else r.addLast(i);
        }
        while (!d.isEmpty() && !r.isEmpty()) {
            //每次比较最前面的一个
            int dd = d.pollFirst(),rr = r.pollFirst();
            //加n是为下一轮继续进行准备
            if (dd < rr) d.addLast(dd+n);
            else r.addLast(rr+n);
        }
        return d.isEmpty() ? "Radiant" : "Dire";
    }
}