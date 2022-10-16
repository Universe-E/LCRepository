import java.util.*;

class Solution {
    public int firstMissingPositive(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) pq.add(i + 1);
        for (int num : nums) if (num > 0) pq.remove(num);
        return pq.isEmpty() ? nums.length + 1 : pq.peek();
        
    }

    public static void main(String[] args) {
        int r = new Solution().firstMissingPositive(new int[]{0, 1, 2});
        System.out.println(r);
    }
}
