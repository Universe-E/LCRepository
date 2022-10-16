class Solution {
    public String reformatNumber(String number) {
        String s = number.replaceAll("[ |-]","");
        char[] chars = s.toCharArray();
        if (s.length() <= 3) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(chars[i]);
            if (i % 3 == 2 && i != s.length() - 1) sb.append('-');
        }
        if (s.length() % 3 == 1) {
            //此时的情况是012-345-6，将其转换为012-34-56
            sb.deleteCharAt(sb.length() - 2);
            sb.insert(sb.length() - 2, '-');
        }
        return sb.toString();
    }
}