class CustomStack {
    int[] arr;
    int idx,capacity,size;
    public CustomStack(int maxSize) {
        capacity = maxSize+1;
        arr = new int[capacity];
        idx = 0;
        size = 0;
    }

    public void push(int x) {
        if (idx != capacity-1) {
            arr[idx++] = x;
        }
    }

    public int pop() {
        if (idx == 0) return -1;
        return arr[--idx];
    }

    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(idx, k); i++) {
            arr[i] += val;
        }
    }
}