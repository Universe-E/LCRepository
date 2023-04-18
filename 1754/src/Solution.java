class Solution {
    public String largestMerge(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        int p1 = 0, p2 = 0;
        StringBuilder sb = new StringBuilder();
        while (p1 < n1 || p2 < n2) {
            String cur1 = p1!=n1 ? word1.substring(p1) : "";
            String cur2 = p2!=n2 ? word2.substring(p2) : "";
            if (cur1.compareTo(cur2) >= 0) {
                sb.append(word1.charAt(p1));
                p1++;
            }
            else if (cur1.compareTo(cur2) < 0) {
                sb.append(word2.charAt(p2));
                p2++;
            }
        }
        return sb.toString();
    }
}