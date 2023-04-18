import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int l = 0, r = 0;
        int res = 0;
        while (r < n) {
            char cur = s.charAt(r);
            if (!set.contains(cur)) {
                set.add(cur);
                r++;
            }
            else {
                while (l <= r) {
                    if (s.charAt(l) != cur) {
                        set.remove(s.charAt(l));
                        l++;
                    }
                    else break;
                }
                if (s.charAt(l) == cur) {
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            res = Math.max(res, set.size());
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}