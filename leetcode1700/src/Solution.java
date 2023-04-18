import java.util.ArrayDeque;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        ArrayDeque<Integer> stack = new ArrayDeque<>(),deque = new ArrayDeque<>();
        int n = sandwiches.length;
        int round = 0;
        for (int i = n - 1; i >= 0; i--) stack.push(sandwiches[i]);
        for (int i = 0; i < n; i++) deque.add(students[i]);
        while (!deque.isEmpty() && !stack.isEmpty()) {
            if (round == deque.size()) break;
            if (deque.peek().equals(stack.peek())) {
                round = 0;
                deque.poll();
                stack.pop();
            }
            else {
                deque.add(deque.poll());
                round++;
            }
        }
        return deque.size();
    }
}