import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        List<ArrayDeque<int[]>> list = new ArrayList<>();
        list.add(new ArrayDeque<>());
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                ArrayDeque<int[]> deque = list.get(j);
                if (deque.isEmpty() || nums[i] > deque.peekFirst()[0]) {
                    if (deque.isEmpty() || deque.size() == 1) deque.addLast(new int[] {nums[i],i});
                    else if (deque.size() == 2) {
                        int[] f = deque.pollFirst();
                        res[f[1]] = nums[i];
                        if (nums[i] > deque.peekFirst()[0]) deque.addLast(new int[] {nums[i], i});
                        else {
                            ArrayDeque<int[]> deque2 = new ArrayDeque<>();
                            deque2.addLast(new int[] {nums[i], i});
                            list.add(deque2);
                        }
                    }
                }
                else if (nums[i] < deque.peekFirst()[0]) {
                    ArrayDeque<int[]> deque2 = new ArrayDeque<>();
                    deque2.addLast(new int[] {nums[i], i});
                    list.add(deque2);
                }
            }
        }
        res[n-2] = -1;
        res[n-1] = -1;
        return res;
    }
}