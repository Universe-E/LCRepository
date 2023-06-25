class Solution {
    public int maximumValue(String[] strs) {
        int res = 0;
        for (String str : strs) {
            boolean hasLetter = false;
            for (int i = 0; i < str.length(); i++) {
                if (Character.isLetter(str.charAt(i))) {
                    res = Math.max(res,str.length());
                    hasLetter = true;
                    break;
                }
            }
            if (!hasLetter) res = Math.max(res,Integer.parseInt(str));
        }
        return res;
    }
}