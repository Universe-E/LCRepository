import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length,m = potions.length;
        Arrays.sort(potions);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if ((long)potions[m-1]*spells[i] < success) res[i] = 0;
            else if ((long)potions[0]*spells[i] >= success) res[i] = m;
            else {
                int l = 0,r = m-1;
                while (l < r) {
                    int mid = (l+r)/2;
                    if ((long)potions[mid]*spells[i] >= success) r = mid;
                    else l = mid + 1;
                }
                res[i] = m-l;
            }
        }
        return res;
    }
}