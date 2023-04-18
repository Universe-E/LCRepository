class Solution {
    public int addMinimum(String word) {
        int res = 0;
        word = word.replaceAll("abc","0").
                replaceAll("ab","1").
                replaceAll("bc","1").
                replaceAll("ac","1").
                replaceAll("a","2").
                replaceAll("b","2").
                replaceAll("c","2");
        for (int i = 0; i < word.length(); i++) {
            res += word.charAt(i) - '0';
        }
        return res;
    }
}