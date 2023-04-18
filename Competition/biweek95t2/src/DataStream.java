class DataStream {

    int value,k,cnt;
    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
        cnt = 0;
    }

    public boolean consec(int num) {
        cnt = num==value ? cnt+1 : 0;
        return cnt >= k;
    }
}