class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0, n = 1;
        //先走到越过target的位置
        //如果相距为偶数，则一定能通过翻转前面的某些步骤到达target
        //如果相距为奇数，则继续多走，直到相距为偶数为止
        while (sum < target || (sum - target) % 2 != 0) {
            sum += n;
            n++;
        }
        return n-1;
    }
}