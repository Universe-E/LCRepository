import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int j = i - 1, k = i + 1;
            while (j >= 0) {
                if (s.charAt(j) == s.charAt(i)) break;
                j--;
            }
            while (k < n) {
                if (s.charAt(k) == s.charAt(i)) break;
                k++;
            }
            res += (i - j) * (k - i);
        }
        return res;
    }
}
class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c,new ArrayList<>());
                map.get(c).add(-1);
            }
            map.get(c).add(i);
        }
        int res = 0;
        for (Character c : map.keySet()) {
            List<Integer> arr = map.get(c);
            arr.add(n);
            for (int i = 1; i < arr.size() - 1; i++) {
                res += (arr.get(i)-arr.get(i-1)) * (arr.get(i+1)-arr.get(i));
            }
        }
        return res;
    }
}

