class Solution {
    public char findTheDifference(String s, String t) {
        String total = s + t;
        if (total.length() == 1) return total.charAt(0);
        int res = total.charAt(0) - 'a';
        for (int i = 1; i < total.length(); i++) {
            res ^= total.charAt(i) - 'a';
        }
        return (char)('a' + res);
    }

    public static void main(String[] args) {
        System.out.println((int) '0');
    }
}
