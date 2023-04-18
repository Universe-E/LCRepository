class Solution {
    public int brokenCalc(int startValue, int target) {
        if (startValue >= target) return startValue - target;
        int l = Integer.MAX_VALUE,r = Integer.MAX_VALUE;
        //如果target除2能除尽，则让startValue和除以二的结果继续比较
        if (target % 2 == 0) l = 1 + brokenCalc(startValue,target / 2);
        //否则让target+1再除2，和startValue继续比较
        else r = 2 + brokenCalc(startValue,(target+1) / 2);
        return Math.min(l,r);
    }
}