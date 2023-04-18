class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int n = (intLength+1)/2;
        long limit = (long)Math.pow(10,n-1)*9;
        long start = (long)Math.pow(10,n-1);
        long[] res = new long[queries.length];
        for(int i=0;i<queries.length;i++){
            if(queries[i]>limit){
                res[i]=-1;
            }
            else{
                String left = String.valueOf(start+queries[i]-1);
                String right = new StringBuilder(left).reverse().toString();
                if(intLength%2==0){
                    res[i]=Long.parseLong(left+right);
                }
                else{
                    res[i]=Long.parseLong(left+right.substring(1));
                }
            }
        }
        return res;
    }
}