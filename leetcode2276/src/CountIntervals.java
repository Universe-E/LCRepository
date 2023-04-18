import java.util.TreeMap;

class CountIntervals {
    TreeMap<Integer, Integer> map;
    int cnt;

    public CountIntervals() {
        map = new TreeMap<>();
        cnt = 0;
    }

    public void add(int left, int right) {
        int l = left, r = right;
        //找到小于等于right的最大key，作为lBound，如果没有，则添加
        Integer lBound = map.floorKey(right);
        //只要区间还在重复范围内，就不断合并区间，找到比lBound更小的左边界，直到找不到为止
        while (lBound != null && map.get(lBound) >= l) {
            //l和r在合并过程中始终维持更新
            l = Math.min(l,lBound);
            r = Math.max(r,map.get(lBound));
            //注意，这里的cnt是重复计数的，因此直接减去区间长度
            cnt -= (map.get(lBound) - lBound + 1);
            map.remove(lBound);
            //移除一个之后，继续寻找更小的小于right的左边界
            lBound = map.floorKey(right);
        }
        map.put(l,r);
        cnt += (r - l + 1);
    }

    public int count() {
        return cnt;
    }
}

class CountIntervals {
    TreeMap<Integer, Integer> map;
    int cnt;

    public CountIntervals() {
        map = new TreeMap<>();
        cnt = 0;
    }

    public void add(int left, int right) {
        Integer lb = map.floorKey(right);
        //如果没有比right更小的左边界，则直接添加[left,right]，此时没有任何重合
        if (lb == null) {
            map.put(left,right);
            cnt += right-left+1;
        }
        //如果有比right更小的左边界，则一直融合，直到找到和[left,right]不重合的区间为止
        else {
            int l = left,r = right;
            while (lb != null && map.get(lb)>=l) {
                //新的区间左边界为l,右边界为r
                l = Math.min(l,lb);
                r = Math.max(map.get(lb),r);
                cnt -= map.get(lb)-lb+1;
                map.remove(lb);
                //更新一下lb
                lb = map.floorKey(right);
            }
            map.put(l,r);
            cnt += (r-l+1);
        }
    }

    public int count() {
        return cnt;
    }
}