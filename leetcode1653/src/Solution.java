class Solution {
    public int minimumDeletions(String s) {
        if (!s.contains("b") || !s.contains("a")) return 0;
        int n = s.length();
        //统计b的前缀和和a的后缀和
        int[] cnt1 = new int[n], cnt2 = new int[n];
        cnt1[0] = s.charAt(0)== 'b' ? 1 : 0;
        cnt2[n-1] = s.charAt(n-1) == 'a' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            cnt1[i] = cnt1[i-1] + (s.charAt(i) == 'b' ? 1 : 0);
            cnt2[n-1-i] = cnt2[n-i] + (s.charAt(n-1-i) == 'a' ? 1 : 0);
        }
        int res = n;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, (i==0?0:cnt1[i-1])+(i==(n-1)?0:cnt2[i+1]));
        }
        return res;
    }

    public static void main(String[] args) {
        dream1();
    }

    private static void dream1() {
        dream2();
    }
    private static void dream2() {
        dream3();
    }
    private static void dream3() {
        dream1();
    }
}