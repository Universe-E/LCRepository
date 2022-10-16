import java.util.ArrayDeque;
import java.util.Queue;

class MovingAverage {

    Queue<Integer> queue;
    int count;
    int size;
    double sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new ArrayDeque<>(size);
        this.count = 0;
        this.size = size;
        this.sum = 0;
    }

    public double next(int val) {
        queue.add(val);
        sum += val;
        count++;
        if (count <= size) {
            return sum / count;
        }
        else {
            sum -= queue.remove();
            return sum / size;
        }
    }
}
