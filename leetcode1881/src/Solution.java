class Solution {
    public String maxValue(String n, int x) {
        int len = n.length();
        char[] cs = new char[len+1];
        System.arraycopy(n.toCharArray(),0,cs,0,len);
        int i;
        if (cs[0] == '-') {
            i = 1;
            //find the insertion index
            while (i < len && cs[i]-'0' <= x) i++;
        }
        else {
            i = 0;
            while (i < len && cs[i]-'0' > x) i++;
        }
        System.arraycopy(n.substring(i).toCharArray(),0,cs,i+1,len-i);
        cs[i] = (char) (x + '0');
        return new String(cs);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxValue("-655",5));
    }
}