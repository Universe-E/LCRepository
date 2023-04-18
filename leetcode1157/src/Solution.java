class MajorityChecker {
    private int[] arrays;
    private int max = 0;
    public MajorityChecker(int[] arr) {
        this.arrays = arr;
        for (int i : arr){
            //查找最大值，利用最大值初始化最小计数器
            this.max = Math.max(i, max);
        }
    }

    public int query(int left, int right, int threshold) {
        //永远无法满足的条件，直接返回-1
        if (threshold > (right-left+1)){
            return -1;
        }
        //初始化计数器，并遍历left到right之间元素的出现次数
        int[] flag = new int[max+1];
        for (;left <= right; left++){
            int ele = this.arrays[left];
            flag[ele]++;
            //当出现满足条件元素时，返回元素
            if (flag[ele] >= threshold){
                return ele;
            }
        }
        return -1;
    }
}