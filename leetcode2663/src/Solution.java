class Solution {

    public String smallestBeautifulString(String s, int k) {
        //长度为m回文串必然包含长度为m−2的回文串
        //所以只需要保证答案不包含长度为2或者长度为3的回文串。
        //换句话说，不能出现s[i]=s[i−1]以及s[i]=s[i−2]。
        //这个性质十分重要，它意味着我们只需要判断s[i]左侧的两个字母。
        k += 'a';
        char[] cs = s.toCharArray();
        int n = cs.length,i = n-1;
        //从最后一个字母开始操作，先让其自增
        cs[i]++;
        while (i < n) {
            if (cs[i] == k) {//此时需要进位
                if (i == 0) return "";//已经是首位，无法进位，此时返回空字符串
                cs[i] = 'a';
                i--;
                cs[i]++;
            }
            //如果找到了回文串，则从最右边增加当前的s[i]，这样保证字典序最小
            else if (i > 0 && cs[i] == cs[i-1] || i > 1 && cs[i] == cs[i-2]) {
                cs[i]++;
            }
            //否则的话当前满足条件，继续向后
            else i++;
        }
        return new String(cs);
    }
}