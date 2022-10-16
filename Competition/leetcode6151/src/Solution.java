import java.util.ArrayList;
import java.util.List;

class Solution {
    public int countSpecialNumbers(int n) {
        List<Character> list = new ArrayList<>();
        int i = 1, res = 0;
        while (i <= n) {
            String s = String.valueOf(i);
            boolean isSpecial = true;
            for (int j = 0; j < s.length(); j++) {
                if (list.contains(s.charAt(j))) {
                    isSpecial = false;
                    break;
                }
                list.add(s.charAt(j));
            }
            if (isSpecial) res++;
            list.clear();
            i++;
        }
        return res;
    }
}
