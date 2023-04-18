class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean isB = Math.max(length,Math.max(width,height)) >= 10000 || (long)length*width*height >= (long)(1e9);
        boolean isH = mass >= 100;
        if (isB && isH) return "Both";
        if (isB) return "Bulky";
        if (isH) return "Heavy";
        return "Neither";
    }
}