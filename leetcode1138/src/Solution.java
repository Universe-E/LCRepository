import java.util.Arrays;

class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder res = new StringBuilder();
        int[] p = new int[2];
        for (char c : target.toCharArray()) {
            int[] t = get(c);
            int dx = t[0]-p[0], dy = t[1]-p[1];
            //当前是z，则先走目标行
            if (p[0] == 5) {
                for (int i = 0; i < Math.abs(dx); i++) {
                    res.append(dx > 0 ? "D" : "U");
                }
                for (int i = 0; i < Math.abs(dy); i++) {
                    res.append(dy > 0 ? "R" : "L");
                }
            }
            else {
                for (int i = 0; i < Math.abs(dy); i++) {
                    res.append(dy > 0 ? "R" : "L");
                }
                for (int i = 0; i < Math.abs(dx); i++) {
                    res.append(dx > 0 ? "D" : "U");
                }
            }
            res.append("!");
            p = Arrays.copyOf(t,2);
        }
        return res.toString();
    }

    private int[] get(char c) {
        return new int[] {(c-'a')/5,(c-'a')%5};
    }
}