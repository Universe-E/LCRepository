import java.util.ArrayDeque;

class MyStack {
    ArrayDeque<Integer> q1, q2;
    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    public void push(int x) {
        q1.addFirst(x);
    }

    public int pop() {
        while (q1.size() > 1) q2.addFirst(q1.pollLast());
        int res = q1.pollLast();
        ArrayDeque<Integer> t = q1;
        q1 = q2;
        q2 = t;
        return res;
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */