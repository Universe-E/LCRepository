class FrontMiddleBackQueue {

    int[] arr;
    int l,r;
    public FrontMiddleBackQueue() {
        arr = new int[5001];
        l = 2500;
        r = 2501;
    }

    public void pushFront(int val) {
        arr[l--] = val;
    }

    public void pushMiddle(int val) {
        int m = (l+r+1)/2;
        for (int i = r; i > m; i--) {
            arr[i] = arr[i-1];
        }
        arr[m] = val;
        r++;
    }

    public void pushBack(int val) {
        arr[r++] = val;
    }

    public int popFront() {
        if (l == r-1) return -1;
        int ret = arr[l+1];
        arr[l+1] = 0;
        l++;
        return ret;
    }

    public int popMiddle() {
        if (l == r-1) return -1;
        int m = (l+r)/2;
        int ret = arr[m];
        for (int i = m+1; i < r; i++) {
            arr[i-1] = arr[i];
        }
        arr[r-1] = 0;
        r--;
        return ret;
    }

    public int popBack() {
        if (l == r-1) return -1;
        int ret = arr[r-1];
        arr[r-1] = 0;
        r--;
        return ret;
    }
}