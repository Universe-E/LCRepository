class Solution {
    public int strStr(String haystack, String needle) {
        //如果needle为空或字符串长度为0，此时不管haystack是什么，都直接返回0即可
        if (needle == null || needle.equals("")) return 0;
        //接下来，讨论needle.length()不为空的情况
        if (haystack == null || haystack.equals("")) return -1;
        //暴力匹配
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean bool = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)){
                        bool = false;
                        break;
                }
            }
            if (bool) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int res = new Solution().strStr(null,"");
        System.out.println(res);
    }
}