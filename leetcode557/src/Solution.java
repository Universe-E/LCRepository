class Solution {
    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        for (int i = 0; i < ss.length; i++) {
            ss[i] = new StringBuilder(ss[i]).reverse().toString();
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < ss.length - 1; i++) {
            res.append(ss[i]).append(' ');
        }
        res.append(ss[ss.length-1]);
        return res.toString();
    }
}