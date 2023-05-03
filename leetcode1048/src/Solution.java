import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] dp = new int[n];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                //check if j is a subsequence of i
                if (check(words[j],words[i])) dp[i] = Math.max(dp[i],dp[j]+1);
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    private boolean check(String w1,String w2) {
        int i = 0, diff = w2.length();
        for (int j = 0; i < w1.length() && j < w2.length(); j++) {
            if (w1.charAt(i) == w2.charAt(j)) {
                i++;
                diff--;
            }
        }
        return i == w1.length() && diff == 1;
    }
}

class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        HashMap<String,Integer> map = new HashMap<>();
        int[] dp = new int[n];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            String w = words[i];
            for (int j = 0; j < w.length(); j++) {
                String cur = w.substring(0,j) + w.substring(j+1);
                if (map.containsKey(cur)) dp[i] = Math.max(dp[i],dp[map.get(cur)]+1);
            }
            map.put(w,i);
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}