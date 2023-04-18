import java.util.Collections;
import java.util.LinkedList;

class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length == 1) return 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        //initialize the number of elements in each bucket, if all elements are the same, cnt is 1 rather than 0
        int cnt = Math.max(100,(max-min)/nums.length);
        //the range is (max-min+1),the number of buckets is (max-min+1-1)/cnt + 1
        int b = (max-min)/cnt+1;
        //use linkedList to store elements
        LinkedList<Integer>[] bs = new LinkedList[b];
        for (int i = 0; i < b; i++) {
            bs[i] = new LinkedList<>();
        }
        //add elements to buckets
        for (int num : nums) {
            bs[(num-min)/cnt].add(num);
        }
        for (LinkedList<Integer> bk : bs) {
            Collections.sort(bk);
        }
        int idx = 0;
        for (LinkedList<Integer> bk : bs) {
            for (Integer val : bk) {
                nums[idx++] = val;
            }
        }
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res,nums[i]-nums[i-1]);
        }
        return res;
    }
}