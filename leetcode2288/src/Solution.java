class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] ss = sentence.split(" ");
        int n = ss.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String s = ss[i];
            if (ok(s)) {
                String l = String.valueOf(Long.parseLong(s.substring(1)) * (100 - discount));
                StringBuilder temp = new StringBuilder(l);
                if (l.length() > 2) temp.insert(l.length()-2,".");
                else {
                    if (l.length() == 1) temp.insert(0,"0.0");
                    else if (l.length() == 2) temp.insert(0,"0.");
                }
                sb.append("$").append(temp);
            }
            else sb.append(s);
            if (i != n-1) sb.append(" ");
        }
        return sb.toString();
    }

    private boolean ok(String s) {
        if (!s.startsWith("$")) return false;
        if (s.length() == 1) return false;
        for (int i = 1; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
}