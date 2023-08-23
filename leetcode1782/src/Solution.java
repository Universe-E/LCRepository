import java.util.*;

class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] d = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int[] e : edges) {
            int x = e[0]-1,y = e[1]-1;
            if (x > y) {
                int t = x;
                x = y;
                y = t;
            }
            d[x]++;
            d[y]++;
            //calculate multiple edges
            map.merge((x<<16)|y,1,Integer::sum);
        }
        int[] res = new int[queries.length];
        int[] sd = d.clone();
        Arrays.sort(sd);
        for (int k = 0; k < queries.length; k++) {
            int floor = queries[k],cur = 0,l = 0,r = n-1;
            while (l < r) {
                if (sd[l]+sd[r] <= floor) l++;
                else {
                    //because sd is sorted, all the i in range [l,r-1] are qualified
                    cur += r-l;
                    r--;
                }
            }
            for (Integer key : map.keySet()) {
                //find how much multiple edges between x and y
                int val = map.get(key);
                //x = key>>16, y = key & 0xffff
                int all = d[key>>16] + d[key&0xffff];
                //if x,y are unqualified but counted, subtract it
                if (all > floor && all-val <= floor) cur--;
            }
            res[k] = cur;
        }
        return res;
    }
}