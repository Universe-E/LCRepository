import java.util.ArrayList;

class Solution {
    public int numberOfBeams(String[] bank) {
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : bank) {
            int c = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') c++;
            }
            if (c != 0) list.add(c);
        }
        int res = 0;
        for (int i = 1; i < list.size(); i++) {
            res += list.get(i)*list.get(i-1);
        }
        return res;
    }
}