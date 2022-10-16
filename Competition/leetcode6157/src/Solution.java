class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int res = 0;
        while (s.contains("01")) {
            s = s.replace("01","10");
            res++;
        }
        return res;
    }
}
