import java.util.PriorityQueue;

class MedianFinder {

    //分别维护最小堆和最大堆，二者大小不超过1
    PriorityQueue<Integer> minpq;
    PriorityQueue<Integer> maxpq;
    int size;
    public MedianFinder() {
        minpq = new PriorityQueue<>();
        maxpq = new PriorityQueue<>((o1,o2) -> (o2 - o1));
        size = 0;
    }

    public void addNum(int num) {
        //初始元素默认向最小堆添加
        if (size == 0) {
            minpq.add(num);
            size++;
            return;
        }
        //如果当前元素比最小堆元素大，则向最小堆添加
        if (num > minpq.peek()) minpq.add(num);
        //否则向最大堆添加
        else maxpq.add(num);
        //堆大小差值不能大于1，否则触发平衡机制
        if (Math.abs(minpq.size() - maxpq.size()) > 1) balance(minpq,maxpq);
        size++;
    }

    public double findMedian() {
        if (size % 2 == 0) return (double) (minpq.peek() + maxpq.peek()) / 2;
        else return minpq.size() > maxpq.size() ? minpq.peek() : maxpq.peek();
    }

    //维护两个堆的平衡，当触发平衡机制时，元素较多的堆的首个元素添加到元素较少的堆中
    private void balance(PriorityQueue<Integer> minpq, PriorityQueue<Integer> maxpq) {
        if (minpq.size() > maxpq.size()) maxpq.add(minpq.poll());
        else minpq.add(maxpq.poll());
    }

}