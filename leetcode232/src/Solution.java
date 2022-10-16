import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {

    Deque<Integer> stack1 ,stack2;
    public MyQueue() {
        stack1 = new ArrayDeque<>();//stack1作为操作栈
        stack2 = new ArrayDeque<>();//stack2作为临时栈
    }

    public void push(int x) {
        while (!stack1.isEmpty()) stack2.push(stack1.pop());
        stack1.push(x);
        while (!stack2.isEmpty()) stack1.push(stack2.pop());
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}
