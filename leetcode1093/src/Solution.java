class Solution {
    public double[] sampleStats(int[] count) {
        long sum = 0,num = 0,modes = 0;
        double min = 256,max = -1,mode = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) continue;
            sum += ((long) count[i]) * i;
            num += count[i];
            if (count[i] > modes) {
                modes = count[i];
                mode = i;
            }
            min = Math.min(min,i);
            max = Math.max(max, i);
        }
        double mean = (double) sum / num;
        double median = 0;
        long mid = 0;
        for (int i = 0,j = -1; i < count.length; i++) {
            if (count[i] == 0) continue;
            if (j != -1) {
                median = (double) (j + i) / 2;
                break;
            }
            mid += count[i];
            if (num % 2 == 0) {
                if (mid == num / 2) {
                    j = i;
                }
                else if (mid > num / 2) {
                    median = i;
                    break;
                }
            }
            else if (mid >= (num / 2) + 1) {
                    median = i;
                    break;
                }
        }
        return new double[] {min,max,mean,median,mode};
    }
}