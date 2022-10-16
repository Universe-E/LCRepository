class MyCircularDeque {

    private int[] arr;
    private int size = 0, front, tail;

    public MyCircularDeque(int k) {
        arr = new int[k];
        tail = k - 1;
    }

    //头部插入元素，头指针左移，如果头指针已经为0则移动到末尾
    public boolean insertFront(int value) {
        if (isFull()) return false;
        if (front == 0) front = arr.length - 1;
        else front = front - 1;
        arr[front] = value;
        size++;
        return true;
    }

    //尾部插入元素，尾指针右移，如果尾指针已经是末尾则移动到0
    public boolean insertLast(int value) {
        if (isFull()) return false;
        if (tail == arr.length - 1) tail = 0;
        else tail = tail + 1;
        arr[tail] = value;
        size++;
        return true;
    }

    //头部删除元素，头指针右移，如果头指针已经是末尾则移动到0
    public boolean deleteFront() {
        if (isEmpty()) return false;
        if (front == arr.length - 1) front = 0;
        else front = front + 1;
        size--;
        return true;
    }

    //尾部删除元素，尾指针左移，如果尾指针已经是0则移动到末尾
    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (tail == 0) tail = arr.length - 1;
        else tail = tail - 1;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    public int getRear() {
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