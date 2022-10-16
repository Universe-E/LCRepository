import java.util.Arrays;

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int multiL1 = getMultiLength(p1,p2);
        int multiL2 = getMultiLength(p1,p3);
        int multiL3 = getMultiLength(p1,p4);
        int multiL4 = getMultiLength(p2,p3);
        int multiL5 = getMultiLength(p2,p4);
        int multiL6 = getMultiLength(p3,p4);
        final int[] Ls = new int[] {multiL1,multiL2,multiL3,multiL4,multiL5,multiL6};
        Arrays.sort(Ls);
        return Ls[0] != 0 && Ls[0] == Ls[1] && Ls[0] == Ls[2] && Ls[0] == Ls[3] && Ls[4] == Ls[5] && Ls[4] == 2* Ls[0];
    }

    private int getMultiLength(int[] p1, int[] p2) {
        return (int) (Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }
}
