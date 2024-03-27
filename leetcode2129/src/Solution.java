class Solution {
    public String capitalizeTitle(String title) {
        StringBuilder res = new StringBuilder();
        String[] ss = title.split(" ");
        for (String s : ss) {
            if (s.length() <= 2) res.append(s.toLowerCase()).append(" ");
            else {
                String c0 = s.substring(0,1).toUpperCase();
                String s2 = s.substring(1).toLowerCase();
                res.append(c0).append(s2).append(" ");
            }
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }
}