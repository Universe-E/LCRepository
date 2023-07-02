class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            //统计当前位出现的次数，只有可能是3k或3k+1次
            for (int num : nums) {
                if ((num & (1 << i)) != 0) cnt++;
            }
            //如果是3k+1次，说明res对该位有贡献
            if (cnt%3 != 0) res += (1<<i);
        }
        return res;
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        int a = 0,b = 0;
        for (int num : nums) {
            a = (a^num) & ~b;
            b = (b^num) & ~a;
        }
        return a;
    }
}