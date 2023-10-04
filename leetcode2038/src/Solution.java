class Solution {
    public boolean winnerOfGame(String colors) {
        int a = 0,b = 0,cnt = 1;
        boolean isA = colors.charAt(0) == 'A';
        for (int i = 1; i < colors.length(); i++) {
            char c = colors.charAt(i);
            if (isA) {
                if (c == 'A') cnt++;
                else {
                    if (cnt >= 3) a += cnt-2;
                    cnt = 1;
                    isA = false;
                }
            }
            else {
                if (c == 'B') cnt++;
                else {
                    if (cnt >= 3) b += cnt-2;
                    cnt = 1;
                    isA = true;
                }
            }
        }
        if (isA) {
            if (cnt >= 3) a += cnt-2;
        }
        else {
            if (cnt >= 3) b += cnt-2;
        }
        return a > b;
    }
}