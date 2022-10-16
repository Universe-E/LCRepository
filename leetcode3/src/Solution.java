import java.util.ArrayList;
import java.util.List;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (!list.contains(s.charAt(j))) list.add(s.charAt(j));
                else break;
            }
            res = Math.max(res,list.size());
            list.clear();
        }
        return res;
    }

    public static void main(String[] args) {
        String s = " ";
        System.out.println(new Solution().lengthOfLongestSubstring(s));

    }
}
