import java.util.Arrays;
import java.util.Random;

class Solution {
    private int[] nums;
    Random rnd;

    public Solution(int[] nums) {
        this.nums = nums.clone();
        rnd = new Random();
    }

    //直接将this.nums赋给nums不好，会让用户在外面修改，所以最好是返回clone()对象
    public int[] reset() {
        return nums.clone();
    }

    public int[] shuffle() {
        int[] arr = nums.clone();
        int r = nums.length-1;
        while (r >= 0) {
            int i = rnd.nextInt(r+1);
            int t = arr[i];
            arr[i] = arr[r];
            arr[r] = t;
            r--;
        }
        return arr;
    }
}
