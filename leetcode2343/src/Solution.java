import java.util.Arrays;

class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length,m = queries.length,len = nums[0].length();
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Integer[] temp = Arrays.copyOf(idx,n);
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int k = queries[i][0], trim = queries[i][1];
            Arrays.sort(temp,(o1,o2) -> {
                String s1 = nums[o1].substring(len-trim), s2 = nums[o2].substring(len-trim);
                if (s1.equals(s2)) return o1-o2;
                return s1.compareTo(s2);
            });
            res[i] = temp[k-1];
            System.arraycopy(idx,0,temp,0,n);
        }
        return res;
    }
}