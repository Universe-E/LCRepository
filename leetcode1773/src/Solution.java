import java.util.List;

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        int rule = -1;
        if (ruleKey.equals("type")) rule = 0;
        if (ruleKey.equals("color")) rule = 1;
        if (ruleKey.equals("name")) rule = 2;
        for (List<String> item : items) {
            String s = item.get(rule);
            if (s.equals(ruleValue)) res++;
        }
        return res;
    }
}