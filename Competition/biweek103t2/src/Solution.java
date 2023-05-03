import java.util.HashSet;

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> sa = new HashSet<>(), sb = new HashSet<>();
        int n = A.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            sa.add(A[i]);
            sb.add(B[i]);
            int cur = 0;
            for (Integer a : sa) {
                if (sb.contains(a)) cur++;
            }
            res[i] = cur;
        }
        return res;
    }
}