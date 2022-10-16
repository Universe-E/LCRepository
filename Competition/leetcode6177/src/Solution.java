import java.util.*;

class Solution {
    public int partitionString(String s) {
        List<Character> curList = new ArrayList<>();
        int res = 1;
        for (int i = 0; i < s.length(); i++) {
            if (curList.contains(s.charAt(i))) {
                res++;
                curList.clear();
            }
            curList.add(s.charAt(i));

        }
        return res;
    }
}