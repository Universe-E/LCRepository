import java.util.ArrayDeque;

class Solution {
    public int maximumGain(String s, int x, int y) {
        int n = s.length(),ab = 0,ba = 0;
        ArrayDeque<Character> q = new ArrayDeque<>(),q2 = new ArrayDeque<>();
        if (x > y) {
            //cal ab
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == 'b' && !q.isEmpty() && q.peekLast() == 'a') {
                    q.pollLast();
                    ab++;
                }
                else q.addLast(c);
            }
            n = q.size();
            //cal ba
            for (int i = 0; i < n; i++) {
                char c = q.pollFirst();
                if (c == 'a' && !q2.isEmpty() && q2.peekLast() == 'b') {
                    q2.pollLast();
                    ba++;
                }
                else q2.addLast(c);
            }
        }
        else {
            //cal ba
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == 'a' && !q.isEmpty() && q.peekLast() == 'b') {
                    q.pollLast();
                    ba++;
                }
                else q.addLast(c);
            }
            //cal ab
            n = q.size();
            for (int i = 0; i < n; i++) {
                char c = q.pollFirst();
                if (c == 'b' && !q2.isEmpty() && q2.peekLast() == 'a') {
                    q2.pollLast();
                    ab++;
                }
                else q2.addLast(c);
            }
        }
        return ab * x + ba * y;
    }
}