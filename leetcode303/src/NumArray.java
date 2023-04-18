import java.util.Arrays;

class NumArray {

    //blocks表示每一组sqrt分解的数据和
    private int[] data, blocks;
    private int n;//元素总数
    private int b;//每组的元素个数，向下取整
    private int bn;//组数

    public NumArray(int[] nums) {
        n = nums.length;
        if (n == 0) return;
        b = (int) Math.sqrt(n);
        bn = ((n-1)/b)+1;
        data = Arrays.copyOf(nums,n);
        blocks = new int[bn];
        for (int i = 0; i < n; i++) {
            blocks[i / b] += nums[i];
        }

    }

    public int sumRange(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n || x > y) return 0;
        //求组号
        int bStart = x/b, bEnd = y/b;
        int res = 0;
        //如果在同一组中，直接求解即可
        if (bStart == bEnd) {
            for (int i = x; i <= y; i++) {
                res += data[i];
            }
            return res;
        }
        //如果不在同一组中，要分三步求解
        //对于bStart所在的组，i要小于下一组的第一个索引
        for (int i = x; i < (bStart+1)*b; i++) {
            res += data[i];
        }
        //中间的组（注意必须是完整组）
        for (int i = bStart+1; i < bEnd; i++) {
            res += blocks[i];
        }
        //bEnd所在的组
        for (int i = bEnd*b; i <= y; i++) {
            res += data[i];
        }
        return res;
    }
}