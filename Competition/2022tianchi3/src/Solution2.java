import java.util.ArrayDeque;
import java.util.HashMap;

public class Solution2 {
    public int[] arrangeBookshelf(int[] order, int limit) {
        HashMap<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (int o : order) {
            map1.put(o,map1.getOrDefault(o,0)+1);
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int o : order) {
            if (map2.getOrDefault(o,0) < limit) {
                //只有当添加的时候，才会考虑从前面取出，且剩下的书得足够用才行
                while (!stack.isEmpty() && stack.peek() > o && map1.get(stack.peek()) >= limit - map2.get(stack.peek()) + 1) {
                    map2.put(stack.peek(),map2.get(stack.peek())-1);
                    stack.pop();
                }
                map2.put(o,map2.getOrDefault(o,0)+1);
                stack.push(o);
            }
            //不管添加还是跳过，当前这本书都从map1中减去
            map1.put(o,map1.get(o)-1);
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pollLast();
        }
        return res;
    }
}
