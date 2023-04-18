import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();
    private static final int[] hs = {1,2,4,8,1,2,4,8,16,32};
    public List<String> readBinaryWatch(int turnedOn) {
        bt(0,0,0,0,turnedOn);
        return res;
    }

    private void bt(int h,int m,int i,int cnt,int turnedOn) {
        if (cnt==turnedOn) {
            if (h <= 11 && m <= 59) {
                String s = h + ":" + (m<10?("0"+m):m);
                res.add(s);
            }
            return;
        }
        for (int j = i; j < 10; j++) {
            if (j<=3) bt(h+hs[j],m,j+1,cnt+1,turnedOn);
            else bt(h,m+hs[j],j+1,cnt+1,turnedOn);
        }
    }
}