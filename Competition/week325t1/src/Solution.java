import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        if (!set.contains(target)) return -1;
        int n = words.length;
        int left = 0, right = 0, i = startIndex, j = startIndex;
        while (!words[i].equals(target)) {
            i = (i+1)%n;
            right++;
        }
        while (!words[j].equals(target)) {
            j = (j-1+n)%n;
            left++;
        }
        return Math.min(left,right);
    }
}