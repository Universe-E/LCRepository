import java.util.*;

public class Solution {
    static Set<Character> vowelsSet = new HashSet<>();
    static {
        char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
        for (char vowel : vowels) {
            vowelsSet.add(vowel);
        }
    }
    public String reverseVowels(String s) {

        char[] cs = s.toCharArray();
        int i = 0,j = s.length() - 1;
        while (i <= j) {
            if (vowelsSet.contains(cs[i]) && !vowelsSet.contains(cs[j])) j--;
            else if (!vowelsSet.contains(cs[i]) && vowelsSet.contains(cs[j])) i++;
            else if (vowelsSet.contains(cs[i]) && vowelsSet.contains(cs[j])) {
                char swap = cs[i];
                cs[i] = cs[j];
                cs[j] = swap;
                i++;
                j--;
            }
            else {
                i++;
                j--;
            }
        }
        return new String(cs);
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(new Solution().reverseVowels(s));
    }
}
