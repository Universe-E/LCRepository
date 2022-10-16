class Solution {
    public int[] missingTwo(int[] nums) {
        int n = nums.length;
        int sum = 0;
        //求所有数之和
        for (int num : nums) {
            sum += num;
        }
        //1到N（即n + 2）所有和
        int all = (n + 2) * (n + 3) / 2;
        //缺失的两数之和
        int diff = all - sum;
        //由于两数不相等，所以两数必定分列于 diff / 2两侧
        //接下来求[1, diff / 2]的之间所有和，问题转化为求缺失的一个数
        int sum2 = 0;
        for (int num : nums) {
            if (num <= diff / 2) sum2 += num;
        }
        int target1 = (diff / 2) * (diff / 2 + 1) / 2 - sum2;
        int target2 = diff - target1;
        return new int[] {target1,target2};

    }
}