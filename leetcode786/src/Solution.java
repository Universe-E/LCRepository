class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double l = 0, r = 1;
        while (true) {
            double mid = (l + r) / 2;
            //store the numerator and denominator of the biggest value
            int x = 0, y = 1;
            //initialize i = -1 to avoid IndexOutOfBound
            int i = -1, cnt = 0;
            //find the total number of fractions smaller than mid
            for (int j = 1; j < n; j++) {
                //in this condition, i won't surpass j
                while ((double)arr[i+1] / arr[j] < mid) {
                    i++;
                    //if (double)arr[i] / arr[j] > (double)x/y, renew the values of x and y
                    if (arr[i] * y > arr[j] * x) {
                        x = arr[i];
                        y = arr[j];
                    }
                }
                cnt += i+1;
            }
            if (cnt == k) return new int[] {x,y};
            if (cnt > k) r = mid;
            else l = mid;
        }
    }
}