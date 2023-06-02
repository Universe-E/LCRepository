import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int d = 0x3f3f3f3f;
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i]-arr[i-1];
            if (d == 0x3f3f3f3f) d = diff;
            else {
                if (diff != d) return false;
            }
        }
        return true;
    }
}

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int mn = 1000007,mx = -10000007,n = arr.length;
        for (int num : arr) {
            mn = Math.min(num, mn);
            mx = Math.max(num, mx);
        }
        int d = (mx-mn)/(n-1),mod = (mx-mn)%(n-1);
        if (mod != 0) return false;
        if (d == 0) return true;//相同数字
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num)) return false;
            set.add(num);
        }
        int count = 0;
        for (int num = mn; num <= mx; num+=d) {
            if (set.contains(num)) ++count;
            else return false;
        }
        return count == n;
    }
}