import java.util.ArrayDeque;

class Solution {
    public int minLength(String s) {
        ArrayDeque<Character> q = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            boolean add = true;
            if (c == 'B' && !q.isEmpty() && q.peekLast() == 'A') {
                q.pollLast();
                add = false;
            }
            if (c == 'D' && !q.isEmpty() && q.peekLast() == 'C') {
                q.pollLast();
                add = false;
            }
            if (add) q.addLast(c);
        }
        return q.size();
    }
}