class Solution {
    public int maxArea(int[] height) {
        //分别声明数组的左右边界
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int minHeight = Math.min(height[i],height[j]);
            if (height[i] < height[j]) i++;
            else j--;
            //不管进行了上述何种操作，长方形宽已减小1，故后续需要+1
            max = Math.max(max,minHeight * (j + 1 - i));
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
