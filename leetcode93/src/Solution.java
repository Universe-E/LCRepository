import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        if (n > 12) return res;
        backTrack(s,n,0,0,new StringBuilder());
        return res;
    }

    private void backTrack(String s,int n,int start,int count,StringBuilder sb) {
        if (count == 3) {
            //看看最后一部分是否合法，注意最后一部分也是回溯的一部分，加入res后要回溯
            String cur = s.substring(start);
            if (isValid(cur)) {
                sb.append(cur);
                res.add(sb.toString());
                sb.delete(sb.length() - cur.length(),sb.length());
            }
            return;
        }
        for (int i = start; i < n; i++) {
            String cur = s.substring(start,i+1);
            if (isValid(cur)) {
                sb.append(cur);
                sb.append('.');
                count++;
                backTrack(s,n,i+1,count,sb);
                count--;
                sb.delete(sb.length() - cur.length() - 1,sb.length());
            }
            else break;
        }
    }

    private boolean isValid(String s) {
        if (s.length() == 1) return true;
        if (s.length() == 2) return s.charAt(0) != '0';
        if (s.length() == 3) {
            if (s.charAt(0) == '0') return false;
            if (s.charAt(0) == '1') return true;
            if (s.charAt(0) == '2') return Integer.parseInt(s.substring(1)) <= 55;
        }
        return false;
    }
}
