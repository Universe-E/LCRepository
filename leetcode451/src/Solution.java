import java.util.Arrays;

class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        int[] cnt = new int[62];
        Integer[] index = new Integer[62];
        for (int i = 0; i < 62; i++) {
            index[i] = i;
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) cnt[c-'A'+26]++;
            else if (Character.isLowerCase(c)) cnt[c-'a']++;
            else cnt[c-'0'+52]++;
        }
        Arrays.sort(index,(o1, o2) -> (cnt[o2]-cnt[o1]));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 62; i++) {
            for (int j = 0; j < cnt[index[i]]; j++) {
                if (index[i] >= 52) sb.append(index[i]-52);
                else if (index[i]>=26) sb.append((char)(index[i]-26+'A'));
                else sb.append((char)(index[i]+'a'));
            }
        }
        return sb.toString();
    }
}