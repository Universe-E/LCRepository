import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int len = queries.length;
        int[][] q2 = new int[len][2];
        for (int i = 0; i < len; i++) {
            q2[i][0] = i;
            q2[i][1] = queries[i];
        }
        Arrays.sort(logs, Comparator.comparingInt(o -> o[1]));
        Arrays.sort(q2,Comparator.comparingInt(o -> o[1]));
        int[] res = new int[len];
        HashMap<Integer,Integer> servers = new HashMap<>();
        for (int i = 0,l = 0,r = 0; i < len; i++) {
            int start = q2[i][1]-x,end = q2[i][1];
            while (r < logs.length && logs[r][1] <= end) {
                servers.put(logs[r][0], servers.getOrDefault(logs[r][0],0)+1);
                r++;
            }
            while (l < r && logs[l][1] < start) {
                servers.put(logs[l][0], servers.get(logs[l][0])-1);
                if (servers.get(logs[l][0]) == 0) servers.remove(logs[l][0]);
                l++;
            }
            res[q2[i][0]] = n-servers.keySet().size();
        }
        return res;
    }
}