import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        backTrack(set,s,new ArrayList<>(),0,n);
        return res;
    }

    private void backTrack(HashSet<String> set,String s,List<String> curString,int start,int length) {
        if (start == length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < curString.size(); i++) {
                sb.append(curString.get(i));
                if (i != curString.size() - 1) sb.append(" ");
            }
            res.add(sb.toString());
            return;
        }
        for (int i = start; i < length; i++) {
            String word = s.substring(start,i + 1);
            if (set.contains(word)) {
                curString.add(word);
                backTrack(set,s,curString,i + 1,length);
                curString.remove(curString.size() - 1);
            }
        }
    }
}