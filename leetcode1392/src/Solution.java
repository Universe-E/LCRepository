class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        //LPS数组，next[i]表示s.substring(0,i + 1)的"boarder"（前缀与后缀相同）长度
        int[] next = new int[n];

        for(int i = 1,j = 0;i < n;i++){
            while(j > 0 && s.charAt(i) != s.charAt(j)){
                j = next[j - 1];
            }
            if(s.charAt(i) == s.charAt(j)) j++;
            next[i] = j;
        }

        return s.substring(0,next[n - 1]);
    }
}