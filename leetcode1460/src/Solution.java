import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(arr);
        Arrays.sort(target);
        return Arrays.equals(target, arr);
    }
}
