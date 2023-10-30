import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public static final int M = (int)1e9 + 7;
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i],i);
        }
        long[] cnt = new long[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                //本身为子树
                if (i==j) cnt[i] = (cnt[i]+1)%M;
                else if (arr[i]%arr[j]==0) {
                    int r = map.getOrDefault(arr[i]/arr[j],-1);
                    if (r != -1) cnt[i] = (cnt[i]+cnt[j]*cnt[r]%M)%M;
                }
            }
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = (res+cnt[i])%M;
        }
        return (int) res;
    }
}

class Solution {
    public static final int M = (int)1e9 + 7;
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i],i);
        }
        int[] cnt = new int[n];
        Arrays.fill(cnt,1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i]%arr[j] != 0) continue;
                int val = map.getOrDefault(arr[i]/arr[j],-1);
                if (val != -1) cnt[i] = (int) ((cnt[i]+(long)cnt[j]*cnt[val])%M);
            }
        }
        int res = 0;
        for (int i : cnt) {
            res = (res+i)%M;
        }
        return res;
    }
}