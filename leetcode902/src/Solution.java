class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        char[] nc = String.valueOf(n).toCharArray();
        int result = 0, len = nc.length, dlen = digits.length;
        for (int i = 1; i < len; i++) result += Math.pow(dlen, i); // 先对【非最高位】的其他位，可组装的数字进行统计
        for (int i = 0; i < len; i++) {
            boolean compareNext = false; // 是否需要对比下一个数字
            for (String digit : digits) {
                char dc = digit.charAt(0); // 将String转换为char
                if (dc < nc[i]) result += Math.pow(dlen, len - i - 1);
                //当且仅当遇到相同数字时，去比较下一个数字，直接跳过本轮比较
                else if (dc == nc[i]) {
                    compareNext = true;
                    break;
                }
            }
            //如果遇到更大数字，即compareNext不是true，此时直接返回结果
            if (!compareNext) return result;
        }
        return ++result; // 如果到最后1位依然满足compareNext，因为最后1位无法再向后对比了，所以最终结果+1
    }
}
