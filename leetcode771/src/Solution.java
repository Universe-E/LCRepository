import java.util.HashSet;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        var set = new HashSet<Character>();
        for (char c : jewels.toCharArray()) {
            set.add(c);
        }
        int res = 0;
        for (char c : stones.toCharArray()) {
            if (set.contains(c)) res++;
        }
        return res;
    }
}