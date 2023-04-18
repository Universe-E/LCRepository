import java.util.ArrayList;

class Solution {
    public int takeCharacters(String s, int k) {
        if (k==0) return 0;
        int n = s.length();
        ArrayList<Integer> al = new ArrayList<>(), bl = new ArrayList<>(), cl = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') al.add(i);
            if (s.charAt(i) == 'b') bl.add(i);
            if (s.charAt(i) == 'c') cl.add(i);
        }
        if (Math.min(al.size(),Math.min(bl.size(),cl.size())) < k) return -1;
        int sa = 0, sb = 0, sc = 0, res = n;
        for (int i = 0; i < n; i++) {
            //分别记录当前i时的abc数量
            if (s.charAt(i) == 'a') sa++;
            if (s.charAt(i) == 'b') sb++;
            if (s.charAt(i) == 'c') sc++;
            //右侧需要取的最大长度
            int right = Math.max(sa>=k ? 0 : n-al.get(al.size()-k+sa),
                    Math.max(sb>=k ? 0 : n-bl.get(bl.size()-k+sb),
                            sc>=k ? 0 : n-cl.get(cl.size()-k+sc)));
            res = Math.min(res,i+1+right);
        }
        //假如全在左侧
        int lsum = Math.max(al.get(k-1)+1,Math.max(bl.get(k-1)+1,cl.get(k-1)+1));
        //假如全在右侧
        int rsum = Math.max(n-al.get(al.size()-k),Math.max(n-bl.get(bl.size()-k),n-cl.get(cl.size()-k)));
        res = Math.min(res,Math.min(lsum,rsum));
        return res;
    }

    public static void main(String[] args) {
        String s = "cbbbac";
        int k = 1;
        System.out.println(new Solution().takeCharacters(s, k));
    }
}