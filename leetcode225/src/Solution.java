import java.util.ArrayDeque;

class MyStack {
    ArrayDeque<Integer> deque1,deque2;
    public MyStack() {
        deque1 = new ArrayDeque<>();
        deque2 = new ArrayDeque<>();
    }

    public void push(int x) {
        deque1.push(x);
    }

    public int pop() {
        return deque1.pop();
    }

    public int top() {
        return deque1.peek();
    }

    public boolean empty() {
        return deque1.isEmpty();
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