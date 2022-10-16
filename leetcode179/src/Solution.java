import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public String largestNumber(int[] nums) {
        //设置优先队列排序规则：按位比较数字大小，较大者排在前面
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int l1 = o1.toString().length(), l2 = o2.toString().length();
            int p1 = 0,p2 = 0;
            //循环比较两数各位数字，退出循环条件为：出现不同数字或循环节相同
            for (int i = 0; !(i % l1 == (l1 - 1) && i % l2 ==(l2 - 1)); i++) {
                if (o1.toString().charAt(p1) != o2.toString().charAt(p2)) break;
                p1++;
                p2++;
                if (p1 == l1) p1 = 0;
                if (p2 == l2) p2 = 0;
            }
            return o2.toString().charAt(p2) - o1.toString().charAt(p1);
        });
        for (int num : nums) pq.add(num);
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 0) sb.append(pq.poll());
        if (sb.indexOf("0") == 0) return "0";
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,11};
        System.out.println(new Solution().largestNumber(nums));
    }
}
