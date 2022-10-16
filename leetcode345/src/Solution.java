import java.util.*;

public class Solution {

    public String reverseVowels(String s) {
        char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
        Set<Character> vowelsSet = new HashSet<>();
        for (char vowel : vowels) {
            vowelsSet.add(vowel);
        }
        char[] temp = s.toCharArray();
        int i = 0,j = s.length() - 1;
        while (i <= j) {
            if (vowelsSet.contains(temp[i]) && !vowelsSet.contains(temp[j])) j--;
            else if (!vowelsSet.contains(temp[i]) && vowelsSet.contains(temp[j])) i++;
            else if (vowelsSet.contains(temp[i]) && vowelsSet.contains(temp[j])) {
                char swap = temp[i];
                temp[i] = temp[j];
                temp[j] = swap;
                i++;
                j--;
            }
            else {
                i++;
                j--;
            }
        }
        StringBuilder res = new StringBuilder();
        for (char c : temp) {
            res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(new Solution().reverseVowels(s));
    }
}
