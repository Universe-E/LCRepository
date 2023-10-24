class Solution {
    public int countSeniors(String[] details) {
        int res = 0;
        for (String d : details) {
            res += Integer.parseInt(d.substring(11,13)) > 60 ? 1 : 0;
        }
        return res;
    }
}