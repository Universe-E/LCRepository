class Solution {
    public int orchestraLayout(int num, int xPos, int yPos) {
        //d表示深度，最外层为0
        long d = Math.min(xPos,Math.min(num-1-xPos,Math.min(yPos,num-1-yPos)));
        //求前d项的等差数列和
        long sum = 4*d*(num-d);
        //求出当前所在正方形到左上顶点[d,d]的项数
        long diff = 0;
        if (xPos == d) diff = yPos-d+1;
        else if (yPos == num-1-d) diff = num-3*d+xPos;
        else if (xPos == num-1-d) diff = (long)3*num-5*d-2-yPos;
        else if (yPos == d) diff = 4*(long)num-7*d-3-xPos;
        return (int) ((sum+diff-1)%9)+1;
    }
}