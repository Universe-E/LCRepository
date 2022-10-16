import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> list = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        backTrack(s,0);
        return list;
    }

    private void backTrack(String s,int i) {
        if (i == s.length()) {
            list.add(s);
            return;
        }
        if (Character.isLetter(s.charAt(i))) {
            StringBuilder sb = new StringBuilder(s);
            sb.replace(i,i + 1,String.valueOf(s.charAt(i)).toUpperCase());
            s = sb.toString();
            backTrack(s,i + 1);
            sb = new StringBuilder(s);
            sb.replace(i, i+1, String.valueOf(s.charAt(i)).toLowerCase());
            s = sb.toString();
        }
        backTrack(s, i+1);
    }
}