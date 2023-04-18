import java.util.ArrayDeque;

class Solution {
    public int[] arrangeBookshelf(int[] order, int limit) {
        int n = order.length;
        //cnt表示剩下的书，cnt2表示已经放上去的书
        int[] cnt = new int[(int)(1e6)],cnt2 = new int[(int)(1e6)];
        for (int value : order) {
            cnt[value]++;
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int value : order) {
            if (cnt2[value] < limit) {
                //只有要添加的时候，才会做出取书的动作，如果不添加就不会取书
                while (!stack.isEmpty()) {
                    //剩下的书得够多
                    if (stack.peek() > value && cnt[stack.peek()] >= limit - cnt2[stack.peek()] + 1) {
                        cnt2[stack.peek()]--;
                        stack.pop();
                    }
                    else break;
                }
                stack.push(value);
                cnt2[value]++;
            }
            //不管添加还是跳过，当前这本书都从cnt[i]中移除
            cnt[value]--;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pollLast();
        }
        return res;
    }
}