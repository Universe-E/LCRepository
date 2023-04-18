class Solution {
    //ij
    //00 -> 00
    //10 -> 11
    //01 -> 11
    //11 -> 10
    //11 -> 01
    //如果s全为0，target也必须全为0
    //只要s有1，target就必须含1
    public boolean makeStringsEqual(String s, String target) {
        if (!s.contains("1")) return !target.contains("1");
        return target.contains("1");
    }
}