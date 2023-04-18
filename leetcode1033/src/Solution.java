import java.util.Arrays;

class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        Arrays.sort(arr);
        int gap1 = arr[1]-arr[0], gap2 = arr[2] - arr[1];
        if (gap1==1 && gap2==1) return new int[]{0,0};
        if (gap1==1) return new int[] {1,gap2-1};
        if (gap2==1) return new int[] {1,gap1-1};
        //否则看哪边的gap大，如果满足最大移动步数，往gap大的那边移动
        return new int[]{Math.min(gap1,gap2)==2?1:2,gap1+gap2-2};
    }
}