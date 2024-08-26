import java.util.HashMap;

class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        int n = word.length(),mx = 0;
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < n - k + 1; i+=k) {
            String key = word.substring(i,i+k);
            map.put(key,map.getOrDefault(key,0)+1);
            mx = Math.max(mx,map.get(key));
        }
        return n / k - mx;
    }
}