import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) return false;
        int[] cnt1 = new int[26], cnt2 = new int[26];
        for (int i = 0; i < n1; i++) {
            cnt1[s1.charAt(i)-'a']++;
        }
        for (int i = 0; i < n1; i++) {
            cnt2[s2.charAt(i)-'a']++;
        }
        if (Arrays.equals(cnt1,cnt2)) return true;
        for (int i = n1; i < n2; i++) {
            cnt2[s2.charAt(i)-'a']++;
            cnt2[s2.charAt(i-n1)-'a']--;
            if (Arrays.equals(cnt1,cnt2)) return true;
        }
        return false;
    }
}