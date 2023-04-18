class RLEIterator {

    int start;//index
    int[] encoding;
    public RLEIterator(int[] encoding) {
        start = 1;//initialize index
        this.encoding = encoding;
    }

    public int next(int n) {
        while (start < encoding.length && n > encoding[start-1]) {
            n -= encoding[start-1];
            encoding[start-1] = 0;
            start += 2;
        }
        //start is out of bound
        if (start > encoding.length) return -1;
        // n <= encoding[start-1]
        encoding[start-1] -= n;
        return encoding[start];
    }
}