import java.util.ArrayDeque;

class MaxQueue {
    ArrayDeque<Integer> deque;
    ArrayDeque<Integer> maxArr;//作为最大队列
    int size;
    public MaxQueue() {
        deque = new ArrayDeque<>();
        maxArr = new ArrayDeque<>();
        size = 0;
    }

    public int max_value() {
        if (size == 0) return -1;
        return maxArr.peek();
    }

    public void push_back(int value) {
        deque.add(value);
        while (!maxArr.isEmpty() && value > maxArr.peekLast()) maxArr.pollLast();
        maxArr.add(value);
        size++;
    }

    //如果这个值是最大值，则该值从最大栈中出栈
    public int pop_front() {
        if (size == 0) return -1;
        int val = deque.poll();
        size--;
        if (val == maxArr.peek()) maxArr.pollFirst();
        return val;
    }
}