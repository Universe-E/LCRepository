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

class Solution {
    public double[] sampleStats(int[] count) {
        long sum = 0,n = 0,modeN = -1;
        double minimum = 256,maximum = -1, mean = 0, median = 0, mode = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                sum += (long) i *count[i];
                n += count[i];
                minimum = Math.min(minimum,i);
                maximum = Math.max(maximum,i);
                if (count[i] > modeN) {
                    modeN = count[i];
                    mode = i;
                }
            }
        }
        mean = (double) sum / n;
        long middle = (n-1)/2 + 1,n2 = 0;
        int pre = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                if (n2 + count[i] < middle) n2 += count[i];
                else {
                    pre = i;
                    break;
                }
            }
        }
        if (n % 2 == 0) {
            if (n2 + count[pre] > middle) {
                median = pre;
            }
            else if (n2 + count[pre] == middle){
                for (int i = pre+1; i < count.length; i++) {
                    if (count[i] != 0) {
                        median = (double) (pre+i)/2;
                        break;
                    }
                }
            }
        }
        else {
            median = pre;
        }
        return new double[] {minimum, maximum, mean, median, mode};
    }
}