import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        int k = indices.length;
        boolean[] replace = new boolean[k];
        Integer[] idx = new Integer[k];
        for (int i = 0; i < k; i++) {
            idx[i] = i;
            String cur = s.substring(indices[i],Math.min(s.length(),indices[i]+sources[i].length()));
            if (cur.equals(sources[i])) replace[i] = true;
        }
        Arrays.sort(idx,Comparator.comparingInt(o->indices[o]));
        int j = 0;
        for (int i = 0; i < k && j < s.length(); i++) {
            int id = idx[i];
            sb.append(s, j, indices[id]);
            j = indices[id];
            if (replace[id]) {
                sb.append(targets[id]);
                j = indices[id]+sources[id].length();
            }
        }
        if (j < s.length()) sb.append(s,j,s.length());
        return sb.toString();
    }
}