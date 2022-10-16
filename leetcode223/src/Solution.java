class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int lengthDistance = Math.max(ax2,bx2) - Math.min(ax1,bx1),
            widthDistance = Math.max(ay2,by2) - Math.min(ay1,by1),
            length1 = ax2 - ax1, length2 = bx2 - bx1,
            width1 = ay2 - ay1, width2 = by2 - by1;
        //如果长宽顶点距离绝对值大于长宽之和，则说明没有覆盖，直接返回面积之和
        if (widthDistance >= width1 + width2 || lengthDistance >= length1 + length2)
            return length1 * width1 + length2 * width2;
        return length1 * width1 + length2 * width2 - (length1 + length2 - lengthDistance) * (width1 + width2 - widthDistance);
    }
}
