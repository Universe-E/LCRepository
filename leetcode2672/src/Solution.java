class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] nums = new int[n],res = new int[queries.length];
        int cur = 0,idx = 0;
        for (int[] query : queries) {
            int i = query[0],color = query[1];
            int c = nums[i],cl = i==0 ? 0 : nums[i-1],cr = i==(n-1) ? 0 : nums[i+1];
            //涂色前，如果i无色则直接为0，如果i有色则判断和左右是否相同
            int pre = c == 0 ? 0 : ((c==cl ? 1 : 0) + (c == cr ? 1 : 0));
            nums[i] = color;
            //涂色后
            int after = (color==cl ? 1 : 0) + (color==cr ? 1 : 0);
            cur += after-pre;
            res[idx++] = cur;
        }
        return res;
    }
}