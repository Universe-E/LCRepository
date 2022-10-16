class Solution {

    int start= 0,end = 0;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";


        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            //找到回文中心i的索引
            i = findLongestString(str, i);
        }
        //substring左闭右开
        return s.substring(start, end + 1);

    }

    private int findLongestString(char[] str, int low) {
        //此处声明high和low相等，接下来如果str[high]和后一位字符相同，则high自增，代表相同字符串，即回文中心
        int high = low;
        while (high < str.length - 1 && str[high] == str[high + 1]){
            high++;
        }
        //随后从回文中心两端向左右扩散，记录当前回文中心的最后一个字符high
        int lastPalindromeCenter = high;
        //只要符合回文条件就一直扩散，
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
        //随后判断当前回文串的长度，如果比end - start大则更新当前的end - start
        if (high - low > end - start){//严格来讲其实应该是high + 1 - low > end + 1 - start
            start = low;
            end = high;
        }

        return lastPalindromeCenter;
    }

    public static void main(String[] args) {
        String s = "aaaaa";
        System.out.println(new Solution().longestPalindrome(s));
    }

}