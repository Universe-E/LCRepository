import java.util.Arrays;

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int[] diff = new int[n];
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        Arrays.sort(cs1);
        Arrays.sort(cs2);
        for (int i = 0; i < n; i++) {
            if (cs1[i] != cs2[i]) return false;
        }
        for (int i = 0; i < n; i++) {
            diff[i] = s1.charAt(i) - s2.charAt(i);
        }

        int nonZero1 = 99;
        int count = 0;
        boolean swap1 = false;
        for (int i = 0; i < n; i++) {
            if (diff[i] != 0) {
                //已经交换过了，不能再出现别的非零值
                if (swap1) return false;
                //第一个非零值赋值给nonZero1
                if (nonZero1 == 99) {
                    nonZero1 = diff[i];
                    count++;
                }
                else {
                    if (diff[i] == - nonZero1) {
                        swap1 = true;
                        count++;
                    }
                    else return false;
                }
            }
        }
        return count == 0 || count == 2;
    }
}