import java.util.ArrayList;

class Solution {
    public int minMoves(int[] nums, int k) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) list.add(i);
        }
        //store the ith preSum of the indexes of nums[i] where nums[i] == 1
        long[] arr = new long[list.size()];
        arr[0] = list.get(0);
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i-1] + list.get(i);
        }
        //converge all the 1 to the mid(the right border if mid is even)
        int mid = k/2 + (k&1);
        long res = Integer.MAX_VALUE;
        for (int i = mid-1; i+k-mid < arr.length; i++) {
            long p = arr[i] - (i!=0 ? arr[i-1] : 0);//p is the index of current 1
            long leftSum = (i==mid-1) ? arr[i] : arr[i]-arr[i-mid];
            long rightSum = arr[i+k/2]-arr[i];
            //move all the left 1s to [p-mid+1,p]
            long leftCost = (2*p-mid+1) * mid / 2 - leftSum;
            //move all the right 1s to [p+1, p+k-mid]
            long rightCost = rightSum - (2*p+1+k-mid)*(k-mid)/2;
            res = Math.min(res,leftCost+rightCost);
        }
        return (int) res;
    }
}