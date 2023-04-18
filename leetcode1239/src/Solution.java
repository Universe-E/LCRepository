import java.util.HashSet;
import java.util.List;

class Solution {
    int res = 0;
    HashSet<Character> set = new HashSet<>();
    public int maxLength(List<String> arr) {
        bt(0,0,arr);
        return res;
    }

    private void bt(int idx,int len,List<String> arr) {
        if (idx == arr.size()) {
            res = Math.max(res,len);
            return;
        }
        for (int i = idx; i < arr.size(); i++) {
            String s = arr.get(i);
            if (check(s)) {
                for (char c : s.toCharArray()) {
                    set.add(c);
                }
                bt(i+1,len+s.length(),arr);
                for (char c : s.toCharArray()) {
                    set.remove(c);
                }
            }
        }
        res = Math.max(res,len);
    }

    //不仅成员变量set不能含重复字母，s自身也不能含重复字母
    private boolean check(String s) {
        HashSet<Character> temp = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (temp.contains(c)) return false;
            temp.add(c);
        }
        for (char c : s.toCharArray()) {
            if (set.contains(c)) return false;
        }
        return true;
    }
}