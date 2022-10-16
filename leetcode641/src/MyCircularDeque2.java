class MyCircularDeque2 {

    private int[] arr;
    private int size = 0;
    private int front;
    private int tail;
    private int capacity;

    public MyCircularDeque2(int k) {
        arr = new int[k + 1];
        front = 0;
        tail = 0;
        capacity = k + 1;
    }

    //头部插入元素，头指针左移，如果头指针已经为0则移动到末尾
    //注意，这里的front指针位于实际“队首”的前一位
    public boolean insertFront(int value) {
        if (isFull()) return false;
        arr[front] = value;
        front = (front - 1 + capacity) % capacity;
        size++;
        return true;
    }

    //尾部插入元素，尾指针右移，如果尾指针已经是末尾则移动到0
    public boolean insertLast(int value) {
        if (isFull()) return false;
        tail = (tail + 1) % capacity;
        arr[tail] = value;
        size++;
        return true;
    }

    //头部删除元素，头指针右移，如果头指针已经是末尾则移动到0
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    //尾部删除元素，尾指针左移，如果尾指针已经是0则移动到末尾
    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail = (tail - 1 + capacity) % capacity;
        size--;
        return true;
    }

    //由于front位于实际“队首”的前一位，因此getFront实际是拿到front的后一位元素
    public int getFront() {
        if (isEmpty()) return -1;
        return arr[(front + 1) % capacity];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return arr[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length - 1;
    }
}