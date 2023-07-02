import java.util.HashSet;

class Solution {
    public boolean buddyStrings(String s, String goal) {
        int n1 = s.length(),n2 = goal.length();
        if (n1 != n2) return false;
        int diff = 0,c10 = 0,c11 = 0,c20 = 0,c21 = 0;
        HashSet<Character> set = new HashSet<>();
        boolean isRepeat = false;
        for (int i = 0; i < n1; i++) {
            char si = s.charAt(i),gi = goal.charAt(i);
            if (set.contains(si)) isRepeat = true;
            set.add(si);
            if (si-gi != 0) {
                if (diff == 0) {
                    c10 = si-'a';
                    c11 = gi-'a';
                }
                else if (diff == 1) {
                    c20 = si-'a';
                    c21 = gi-'a';
                }
                else return false;
                diff++;
            }
        }
        //如果错位数为0，则s必须含有重复字符
        if (diff == 0) return isRepeat;
        //如果错位数为2，则二者必须抵消相等
        if (diff == 2) return c10 == c21 && c11 == c20;
        //其他情况都不行
        return false;
    }
}