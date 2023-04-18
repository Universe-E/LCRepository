import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        int n = s.length();
        bt(s,n,0,new StringBuilder());
        return res;
    }

    private void bt(String s,int n,int i,StringBuilder sb) {
        if (i == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < n; j++) {
            sb.append(s.charAt(j));
            if (isValid(sb.toString())) {
                list.add(sb.toString());
                bt(s,n,j+1,new StringBuilder());
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isValid(String s) {
        int l = 0, r = s.length()-1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}