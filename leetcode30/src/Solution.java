import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        int sLength = words.length * words[0].length();
        for (int i = 0; i < s.length() - sLength; i++) {
            //取出当前的字符串
            String cur = s.substring(i,i + sLength + 1);
            for (int j = 0; j < words.length; j++) {
                if (cur.s)
            }
        }
    }
}
