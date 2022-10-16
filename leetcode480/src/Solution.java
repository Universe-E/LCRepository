import java.util.TreeSet;

class Solution {
    int[] nums;//全局变量
    //注意，比较时不能直接相减，否则会整型溢出
    TreeSet<Integer> minpq = new TreeSet<>((o1,o2) -> (nums[o1] == nums[o2] ? o1 - o2 : nums[o1] < nums[o2] ? -1 : 1));//最小值在前
    TreeSet<Integer> maxpq = new TreeSet<>((o1,o2) -> (nums[o1] == nums[o2] ? o1 - o2 : nums[o1] < nums[o2] ? 1 : -1));//最大值在前
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        this.nums = nums;
        double[] res = new double[n - k + 1];
        for (int i = 0; i < k; i++) addElement(i);
        for (int i = 0; i < n - k + 1; i++) {
            if (i != 0) {
                addElement(i + k - 1);
                removeElement(i - 1);
            }
            res[i] = k % 2 == 0 ?  ((double)nums[minpq.first()] + (double)nums[maxpq.first()]) / 2
                    : minpq.size() > maxpq.size() ? nums[minpq.first()] : nums[maxpq.first()];
        }
        return res;
    }

    private void addElement(int i) {
        if (minpq.size() == 0) {
            minpq.add(i);
            return;
        }
        //如果当前元素比minpq首部元素小，则往maxpq里添加
        if (nums[i] < nums[minpq.first()]) maxpq.add(i);
        //否则往minpq里添加
        else minpq.add(i);
        balance();
    }

    private void removeElement(int i) {
        if (minpq.contains(i)) minpq.remove(i);
        else maxpq.remove(i);
        balance();
    }

    //如果队列大小相差大于1，则维护平衡
    private void balance() {
        if (minpq.size() - maxpq.size() > 1) maxpq.add(minpq.pollFirst());
        else if (maxpq.size() - minpq.size() > 1) minpq.add(maxpq.pollFirst());
    }
}