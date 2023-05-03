import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] supplyWagon(int[] supplies) {
        int len = supplies.length;//初始化长度
        while (supplies.length > len / 2) {
            int min = 2001,idx = -1;//起始坐标为idx
            for (int i = 0; i < supplies.length - 1; i++) {
                int curSum = supplies[i] + supplies[i+1];
                if (curSum < min) {
                    min = curSum;
                    idx = i;
                }
            }
            supplies[idx] = min;
            int[] temp = new int[supplies.length-1];
            System.arraycopy(supplies, 0, temp, 0, idx+1);
            System.arraycopy(supplies,idx+2,temp,idx+1,supplies.length-idx-2);
            supplies = temp;
        }
        return supplies;
    }
}