class Solution {
    public int integerReplacement(int n) {
        int res = 0;
        long m = n;
        while (m != 1) {
            //如果最后两位都是1，且该数不是3，则选择+1，为避免2147483647溢出选择long，
            if (m != 3 && (m & 3) == 3) m++;
            else if ((m & 1) == 1) m--;
            else if ((m & 1) == 0) m >>= 1;
            res++;
        }
        return res;
    }
}