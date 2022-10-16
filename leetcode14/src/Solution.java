class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1 && strs[0].equals("")) return "";
        StringBuilder res = new StringBuilder();
        //直接选第一个单词
        char[] prefix = strs[0].toCharArray();
        int i = 0;
        while (i <= prefix.length) {
            //逐个判断，如果一个不符合条件，直接返回
            for (String s : strs) {
                if (i >= s.length() || s.charAt(i) != prefix[i]) return res.toString();
            }
            res.append(prefix[i]);
            i++;
        }
        return res.toString();
    }
}
