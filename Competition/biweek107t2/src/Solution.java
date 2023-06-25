class Solution {
    public int longestString(int x, int y, int z) {
        return 2*(Math.min(x,y)*2 + (x==y ? 0 : 1) + z);
    }
}