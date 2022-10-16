import java.util.Arrays;

class Solution2 {
    public String shiftingLetters(String s, int[][] shifts) {
        //按照线段树的思路计算每一位的位移总距离
        int[] idxArray = new int[s.length()];
        Arrays.fill(idxArray, 0);
        for (int[] shift : shifts) {
            if (shift[2] == 0) for (int i = shift[0]; i < shift[1] + 1; i++) idxArray[i]--;
            else for (int i = shift[0]; i < shift[1] + 1; i++) idxArray[i]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int diff = s.charAt(i) - 'a' + idxArray[i] % 26;
            if (diff < 0) sb.append((char)('z' + diff + 1));
            else if (diff >= 26) sb.append((char)('a' + diff % 26));
            else sb.append((char)('a' + diff));
        }
        return sb.toString();
    }
}

