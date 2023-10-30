import java.util.Arrays;

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxHorizon = horizontalCuts[0],maxVertical = verticalCuts[0];
        for (int i = 1; i < horizontalCuts.length; i++) {
            maxHorizon = Math.max(maxHorizon,horizontalCuts[i]-horizontalCuts[i-1]);
        }
        maxHorizon = Math.max(maxHorizon,h-horizontalCuts[horizontalCuts.length-1]);
        for (int i = 1; i < verticalCuts.length; i++) {
            maxVertical = Math.max(maxVertical,verticalCuts[i]-verticalCuts[i-1]);
        }
        maxVertical = Math.max(maxVertical,w-verticalCuts[verticalCuts.length-1]);
        System.out.println(maxHorizon+","+maxVertical);
        return (int) ((long)maxHorizon*maxVertical%((int)1e9+7));
    }
}