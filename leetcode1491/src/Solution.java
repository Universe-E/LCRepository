class Solution {
    public double average(int[] salary) {
        int n = salary.length, max = 0, min = 0x3f3f3f3f,sum = 0;
        for (int s : salary) {
            sum += s;
            max = Math.max(max,s);
            min = Math.min(min,s);
        }
        return (double)(sum-max-min) / (n-2);
    }
}