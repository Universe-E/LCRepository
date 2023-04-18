import java.util.ArrayList;

class SnapshotArray {
    int cnt = 0;
    ArrayList<int[]>[] arr;
    ArrayList<Integer> snapList;
    public SnapshotArray(int length) {
        arr = new ArrayList[length];
//        Arrays.fill(arr,new ArrayList<>());//这样数组索引指向的是同一个list，不能这样初始化list数组！
        for (int i = 0; i < length; i++) {
            arr[i] = new ArrayList<>();
        }
        snapList = new ArrayList<>();
    }

    public void set(int index, int val) {
        arr[index].add(new int[]{val,++cnt});
    }

    //每次记录当前的操作数
    public int snap() {
        snapList.add(cnt);
        return snapList.size()-1;
    }

    public int get(int index, int snap_id) {
        ArrayList<int[]> curList = arr[index];
        if (curList.isEmpty()) return 0;//如果curList没有元素，直接返回0即可
        int curCnt = snapList.get(snap_id);//得到snap_id对应的最近一次set操作数，记作curCnt
        //二分查找curList里小于等于curCnt的最大索引对应的值
        int l = 0,r = curList.size()-1;
        if (curList.get(l)[1] > curCnt) return 0;//注意单独判断找不到的情况
        while (l < r) {
            int m = (l+r+1)/2;
            if (curList.get(m)[1] > curCnt) r = m-1;
            else l = m;
        }
        return curList.get(l)[0];
    }
}
