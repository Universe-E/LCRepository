import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int adventureCamp(String[] expeditions) {
        int n = expeditions.length,res = -1,max = 0;
        String[] s0 = expeditions[0].split("->");
        HashSet<String> set = new HashSet<>();
        if (!expeditions[0].equals("")) set.addAll(Arrays.asList(s0));
        for (int i = 1; i < n; i++) {
            int cur = 0;
            if (!expeditions[i].equals("")) {
                String[] cs = expeditions[i].split("->");
                HashSet<String> curSet = new HashSet<>(Arrays.asList(cs));
                for (String s : curSet) {
                    if (!set.contains(s)) {
                        cur++;
                        set.add(s);//新发现，加入集合
                    }
                }
            }
            if (cur > max) {
                max = cur;
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "";
        String[] s0 = s.split("->");
        System.out.println(s0.length);
        for (String s1 : s0) {
            System.out.println(s1);
        }
    }
}