class MyCircularQueue {

    private int[] arr;
    private int front,tail,size;

    public MyCircularQueue(int k) {
        arr = new int[k];
        front = 0;
        tail = k - 1;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        tail = tail == arr.length - 1 ? 0 : tail + 1;
        arr[tail] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        front = front == arr.length - 1 ? 0 : front + 1;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return arr[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }
}
