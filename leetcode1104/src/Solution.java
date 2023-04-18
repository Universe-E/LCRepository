import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int depth = getDepth(label);
        while (depth != 0) {
            deque.addFirst(label);
            depth--;
            //计算下一个diff
            int diff = getDiff(label) / 2;
            if (depth % 2 == 0) label = (int)Math.pow(2,depth)-1-diff;
            else label = (int)Math.pow(2,depth-1)+diff;
        }
        return new ArrayList<>(deque);
    }

    //找到深度，默认根节点为0
    private int getDepth(int n) {
        if (n == 1) return 1;
        return 1 + getDepth(n / 2);
    }

    //找到相对最左节点的偏移量
    private int getDiff(int n) {
        int depth = getDepth(n);
        if (depth % 2 == 0) return (int) Math.pow(2,depth)-n-1;
        else return n - (int)Math.pow(2,depth-1);
    }
}